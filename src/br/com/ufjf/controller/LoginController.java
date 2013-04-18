/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.controller;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.ufjf.modelo.User;
import br.com.ufjf.repository.UserRepository;
import br.com.ufjf.base.MetodoAuxiliar;
import br.com.ufjf.msg.Mensageiro;

@ManagedBean
@SessionScoped
public class LoginController {


    @EJB
    private UserRepository adminuserDao;

	private String login;
	private String senha;
	private String msgLogin;
	private String originalViewId;
	private User adminuser;
	private String mensagemErro;
	@SuppressWarnings("unused")
	private FacesContext facesContext;

	private String nomeuser;

	public String getMensagemErro() {
		return mensagemErro;
	}

	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

	public User getAdminuser() {
		return adminuser;
	}

	public void setAdminuser(User adminuser) {
		this.adminuser = adminuser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMsgLogin() {
		return msgLogin;
	}

	public void setMsgLogin(String msgLogin) {
		this.msgLogin = msgLogin;
	}

	public String getOriginalViewId() {
		return originalViewId;
	}

	public void setOriginalViewId(String originalViewId) {
		this.originalViewId = originalViewId;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
	public String getNomeuser() {
		return nomeuser;
	}

	public void setNomeuser(String nomeuser) {
		this.nomeuser = nomeuser;
	}

	// verifica a existência do administrador e o retorna
	private User verificaAdmin(String login, String senha) {
		User userLogin = new User();
		//AdminuserRepository adminuserDao = new AdminuserRepository();
		try {
			String query = "SELECT a FROM User a WHERE a.loginScientist= :login and a.senhaScientist= :senha";
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("login", login);
			String senhaCripto = MetodoAuxiliar.geraMD5(senha);
			params.put("senha", senhaCripto);
			userLogin = adminuserDao.pesqParam(query, params);

			nomeuser = userLogin.getNomeScientist();
			
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE,
					null, ex);
		}

		return userLogin;
	}

	public String validaLogin() {// adminuser.getLogin()
		User a = verificaAdmin(login, senha);
		// verifica se a senha resultante é
		// igual a senha encontrada no banco de dados
		if (a != null) {// adminuser.getSenha())
			// deixa o objeto usuario agora com os
			// valores encontrados no banco
			setAdminuser(a);
			// caso não seja nulo
			// redireciona onde o usuário tentou entrar
			// via URL

			facesContext = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) FacesContext
					.getCurrentInstance().getExternalContext().getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("adminLogado", a);
			
			//String nomeLogado  = adminLogado.get

			// redireciona para a área do usuário
			return "/upload";

		} else {
			Mensageiro.errorMsg("loginMsg");
		}

		return null;

	}

	// sai da área administrativa
	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		Object session = externalContext.getSession(false);
		HttpSession httpSession = (HttpSession) session;
		httpSession.invalidate();
		return "/home";

	}
}