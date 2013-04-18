package br.com.ufjf.base;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author MAGNUS
 */
public class MetodoAuxiliar {

    @SuppressWarnings("unused")
	private static int auxMenu = 0;
    @SuppressWarnings("unused")
	private static int auxMenu2 = 0;
    @SuppressWarnings("unused")
	private static String auxMenu3 = "";
    @SuppressWarnings("unused")
	private static int auxMenu5 = 0;
    @SuppressWarnings("unused")
	private static Scanner le = new Scanner(System.in);
    private static String linha;
    private static ArrayList<String> comp = new ArrayList<String>();

    
    
    public static String retiraAspasHtml(String input) {
    Pattern p = Pattern.compile("<.*?>");
    Matcher m = p.matcher(input);
    String semHtml = m.replaceAll("");
    String semAspas = semHtml.replaceAll("'", "");
    return semAspas;
    }
    
    
    
    
    @SuppressWarnings("unused")
	private static int geraAleatorio() {
        int num = 1000 + (int) (6 * Math.random());
        return num;
    }
//sorteia um numero aleatoreo sem repetição
    @SuppressWarnings("rawtypes")
	private static ArrayList sorteados = new ArrayList();

    @SuppressWarnings("unchecked")
	public static int sorteia() {
        Random r = new Random();
        final int H = 999; // sorteia entre 1 e 1000
        final int L = 1;
        int result;
        do {
            result = r.nextInt(H + 1) + L;
        } while (!sorteados.add(new Integer(result)));
        return result;

    }
//formata data

    public static Date formataData(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }

        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = (java.util.Date) formatter.parse(data);
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }
//valida data

    public static boolean verificaData(String texto) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(texto);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
//valida hora

    public static boolean verificaHora(String texto) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setLenient(false);
        try {
            sdf.parse(texto);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
    // verdadeiro falso se o que eu digitei é numerico

    @SuppressWarnings("unused")
	public static boolean ehNumerico(String string) {
        boolean result = false;
        try {
            int num = Integer.parseInt(string);
            result = true;
        } catch (NumberFormatException ex) {
            result = false;
        }
        return result;
    }

    public static boolean ehNumerico02(String valor) {
        boolean valido = true;
        for (int i = 0; i < valor.length(); i++) {
            Character caractere = valor.charAt(i);
            if (!Character.isDigit(caractere)) {
                valido = false;
                break;
            }
        }

        return valido;
    }

    public static boolean tamanhoIgualA11(String valor) {
        boolean valido = true;
        int tamanho = valor.length();
        if (tamanho == 11) {
            valido = true;
        } else {
            valido = false;
        }


        return valido;
    }

    //verifica se numero que eu digitar esta na faixa 1 a 4
    public static boolean nhaFaixa1(String fx) {
        boolean result = false;
        boolean mum = ehNumerico(fx);
        if (mum == false) {
            result = false;
        } else {
            int fx1 = Integer.parseInt(fx);
            if ((fx1 <= 0) | (fx1 >= 4)) {
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }

    public static boolean naFaixaEntre1e9(String fx) {
        boolean result = false;
        boolean mum = ehNumerico(fx);
        int fx1 = Integer.parseInt(fx);
        if (mum == false) {
            result = false;
        } else {
            if ((fx1 <= 0) | (fx1 >= 10)) {// intervalo de 1 a 9 
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }

    //metodo verifica se é numerico e esta na faixa de 1 a 2
    public static boolean naFaixaEntre1e2(String fx) {
        boolean result = false;
        boolean mum = ehNumerico(fx);
        int fx1 = Integer.parseInt(fx);
        if (mum == false) {
            result = false;
        } else {
            if ((fx1 <= 0) | (fx1 >= 3)) {//vai de 1 a 2// os extremos é falso
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }

//metodo verifica se é numerico e esta na faixa de 1 a 2
    public static boolean tamanhoEntre4e9(int fx) {

        boolean result = false;


        if ((fx <= 4) | (fx >= 9)) {//vai de 1 a 2// os extremos é falso
            result = false;
        } else {
            result = true;
        }


        return result;
    }

    public static boolean tamanhoEntre1e11(int fx) {

        boolean result = false;


        if ((fx <= 0) | (fx >= 12)) {//vai de 1 a 2// os extremos é falso
            result = false;
        } else {
            result = true;
        }


        return result;
    }

    //verifica se numero que eu digitar esta na faixa 1 a 6
    public static boolean nhaFaixa2(String fx) {
        boolean result = false;
        boolean mum = ehNumerico(fx);
        if (mum == false) {
            result = false;
        } else {
            int fx1 = Integer.parseInt(fx);
            if ((fx1 <= 0) | (fx1 >= 6)) {
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }

    public static boolean naFaixaEntre1e5(String fx) {
        boolean result = false;
        boolean mum = ehNumerico(fx);
        int fx1 = Integer.parseInt(fx);

        if (mum == false) {
            result = false;
        } else {
            if ((fx1 <= 0) | (fx1 >= 6)) {//vai de 1 a 5// os extremos é falso
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }
    //se é numerio e na faixa de 1 a 6

    public static boolean naFaixaEntre1e6(String fx) {
        boolean result = false;
        boolean mum = ehNumerico(fx);
        int fx1 = Integer.parseInt(fx);

        if (mum == false) {
            result = false;
        } else {
            if ((fx1 <= 0) | (fx1 >= 7)) {//vai de 1 a 6// os extremos é falso
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }

    //se é numerio e na faixa de 1 a 6
    public static boolean naFaixaEntre1a7(String fx) {
        boolean result = false;
        boolean mum = ehNumerico(fx);
        int fx1 = Integer.parseInt(fx);

        if (mum == false) {
            result = false;
        } else {
            if ((fx1 <= 0) | (fx1 >= 8)) {//vai de 1 a 7// os extremos é falso
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }

    //se é numerio e na faixa de 1 a 8
    public static boolean naFaixaEntre1e8(String fx) {
        boolean result = false;
        boolean mum = ehNumerico(fx);
        int fx1 = Integer.parseInt(fx);
        if (mum == false) {
            result = false;
        } else {
            if ((fx1 <= 0) | (fx1 >= 9)) {//vai de 1 a 8// os extremos é falso
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }

    //se é numerio e na faixa de 1 a 8
    public static boolean naFaixaEntre1a9(String fx) {
        boolean result = false;
        boolean mum = ehNumerico(fx);
        int fx1 = Integer.parseInt(fx);
        if (mum == false) {
            result = false;
        } else {
            if ((fx1 <= 0) | (fx1 >= 10)) {//vai de 1 a 9// os extremos é falso
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }

    //verifica se numero que eu digitar esta na faixa 1 a 6
    public static boolean nhaFaixa1a8(String fx) {
        boolean result = false;
        boolean mum = ehNumerico(fx);
        if (mum == false) {
            result = false;
        } else {
            int fx1 = Integer.parseInt(fx);
            if ((fx1 <= 0) || (fx1 >= 8)) {
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }
    //verifica se numero que eu digitar esta na faixa 1 A 2

    public static boolean nhaFaixa3(String fx) {
        boolean result = false;
        boolean mum = ehNumerico(fx);
        if (mum == false) {
            result = false;
        } else {
            int fx1 = Integer.parseInt(fx);
            if ((fx1 >= 0) | (fx1 >= 3)) {
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }
//verifica se é um numero é se está na faixa 1 ate 3 ou seja 1,2,3

    public static boolean naFaixaEntre1e3(String fx) {
        boolean result = false;
        boolean mum = ehNumerico(fx);
        int fx1 = Integer.parseInt(fx);

        if (mum == false) {
            result = false;
        } else {
            if ((fx1 <= 0) | (fx1 >= 4)) {//observando so extremos menor igual a zero ou maior igual a quatro
                result = false;
            } else {
                result = true;
            }
        }

        return result;
    }
    /*&&	E ("logical AND") a && b
    retorna true se a e b forem ambos true. Senão retorna false. Se a for false, b não é avaliada.
    
    &	E ("boolean logical AND") a & b
    retorna true se a e b forem ambos true. Senão retorna false. Ambas expressões a e b são sempre avaliadas.
    
    ||	OU ("logical OR") a || b
    retorna true se a ou b for true. Senão retorna false. Se a for true, b não é avaliada.
    
    |	OU ("boolean logical inclusive OR") a | b
    retorna true se a ou b for true. Senão retorna false. Ambas expressões a e b são sempre avaliadas.
    
    ^	OU EXCLUSIVO ("boolean logical exclusive OR") a ^ b
    retorna true se a for true e b for false ou vice-versa. Senão retorna false
    
    !	NÃO ("logical NOT") !a
    retorna true se a for false. Senão retorna false */
    // static IDentificador idnt = new IDentificador();
    //metodo salvarArquivo pasando tres parametros

    public static void salvarArquivo(String arquivo, String conteudo, boolean adicionar)
            throws IOException {
        adicionar = false;
        FileWriter fw = new FileWriter(arquivo, adicionar);

        fw.write(conteudo);
        fw.close();
    }
    public static Scanner le2 = new Scanner(System.in);

    //RETORNA  (tamanho 7 algaritmos)
    public static boolean validaIdentificador(String I) {
        boolean n = false;
        int charCount = I.length();
        if (charCount == 7) {
            n = true;
        } else {
            n = false;
        }

        return n;
    }

    /*DEFINITIVAMENTE IMPRIMIR UM ARRAYLIST
    ArrayList<Object> al = new ArrayList<Object>();  
    al.add("Teste");  
    al.add(new Integer(1));  
    al.add(new Long(2));  
    al.add(new Float(3.3));  
    al.add(Boolean.TRUE);  
     * 
    ArrayList<Object> al = new ArrayList<Object>();
    Iterator it = al.iterator();  
    while (it.hasNext()) {  
    System.out.println(it.next());  
    }  */
    //// Metodo para retornar numero da semana anual do referido mes
    public static Integer[] getWeeksOfMonth(int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Set<Integer> weeks = new HashSet<Integer>();

        int ndays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < ndays; i++) {
            weeks.add(cal.get(Calendar.WEEK_OF_YEAR));

            cal.add(Calendar.DATE, 1);
        }
        return weeks.toArray(new Integer[0]);

    }

    /*BACKUP
     * public static ArrayList<Datas> getDiasDeDeusTerQua(int mes, int ano) {
    // Calendar cal = Calendar.getInstance(); 
    //cal.set(Calendar.YEAR, ano); 
    // cal.set(Calendar.MONTH, mes); 
    // cal.set(Calendar.DAY_OF_MONTH, 1); 
    Set<Integer> weeks = new HashSet<Integer>();
    ArrayList<Datas> datas = new ArrayList<Datas>();
    ArrayList<Datas> dataCorreta = new ArrayList<Datas>();
    
    Date T = null;
    GregorianCalendar calendar = new GregorianCalendar();
    Calendar data = new GregorianCalendar();
    Date hoje = data.getTime();
    int dia = 1;
    
    data.set(ano, mes, dia);
    
    int diaMaximo = data.getActualMaximum(Calendar.DAY_OF_MONTH); 
    for ( dia = 1; dia <= diaMaximo; dia++) {
    data.set(Calendar.DAY_OF_MONTH, dia);
    int diaDaSemana = data.get(Calendar.DAY_OF_WEEK);
    if ((diaDaSemana == Calendar.TUESDAY) || (diaDaSemana == Calendar.WEDNESDAY)) {//1 = terça e 2 = quarta
    T = data.getTime();   
    if(hoje.before(T)){//before = antes - after = depois
    String formato = "dd/MM/yyyy";
    SimpleDateFormat formatter = new SimpleDateFormat(formato);
    String dateRetorn = formatter.format(T);
    Datas dts = new Datas();
    dts.setDatas(dateRetorn);
    datas.add(dts);  
    }
    }
    }   
    
    
    
    return datas;   
    } 
    
   
    public static ArrayList<Datas> getDiasDeDeusTerQua(int mes, int ano) {

        Set<Integer> weeks = new HashSet<Integer>();
        ArrayList<Datas> datas = new ArrayList<Datas>();
        ArrayList<Datas> dataCorreta = new ArrayList<Datas>();

        Date T = null;
        GregorianCalendar calendar = new GregorianCalendar();
        Calendar data = new GregorianCalendar();
        Date hoje = data.getTime();
        int dia = 1;

        data.set(ano, mes, dia);

        int diaMaximo = data.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (dia = 1; dia <= diaMaximo; dia++) {
            data.set(Calendar.DAY_OF_MONTH, dia);
            int diaDaSemana = data.get(Calendar.DAY_OF_WEEK);
            if ((diaDaSemana == Calendar.WEDNESDAY) || (diaDaSemana == Calendar.THURSDAY)) {//1 = terça e 2 = quarta
                T = data.getTime();
                if (hoje.before(T)) {//before = antes - after = depois
                    int diaDaSemanaE = data.get(Calendar.DAY_OF_WEEK);
                    String formato = "dd/MM/yyyy";
                    SimpleDateFormat formatter = new SimpleDateFormat(formato);
                    String dateRetorn = formatter.format(T);
                    Datas dts = new Datas();
                    String g = getDiaDaSemana(diaDaSemana);
                    dts.setDatas(dateRetorn);
                    dts.setDia(g);
                    datas.add(dts);
                }
            }
        }



        return datas;
    }

    public static ArrayList<Datas> getDiasDeDeusQuaQui(int mes, int ano) {

        Set<Integer> weeks = new HashSet<Integer>();
        ArrayList<Datas> datas = new ArrayList<Datas>();
        ArrayList<Datas> dataCorreta = new ArrayList<Datas>();

        Date T = null;
        GregorianCalendar calendar = new GregorianCalendar();
        Calendar data = new GregorianCalendar();
        Date hoje = data.getTime();
        int dia = 1;

        data.set(ano, mes, dia);

        int diaMaximo = data.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (dia = 1; dia <= diaMaximo; dia++) {
            data.set(Calendar.DAY_OF_MONTH, dia);
            int diaDaSemana = data.get(Calendar.DAY_OF_WEEK);
            if ((diaDaSemana == Calendar.WEDNESDAY) || (diaDaSemana == Calendar.THURSDAY)) {//1 = terça e 2 = quarta
                T = data.getTime();
                if (hoje.before(T)) {//before = antes - after = depois
                    int diaDaSemanaE = data.get(Calendar.DAY_OF_WEEK);
                    String formato = "dd/MM/yyyy";
                    SimpleDateFormat formatter = new SimpleDateFormat(formato);
                    String dateRetorn = formatter.format(T);
                    Datas dts = new Datas();
                    String g = getDiaDaSemana(diaDaSemana);
                    dts.setDatas(dateRetorn);
                    dts.setDia(g);
                    datas.add(dts);
                }
            }
        }



        return datas;
    }

    public static ArrayList<Datas> getDiasDeDeusTerQuaAnoSeguinte(int mes, int ano) {

        Set<Integer> weeks = new HashSet<Integer>();
        ArrayList<Datas> datas = new ArrayList<Datas>();
        ArrayList<Datas> dataCorreta = new ArrayList<Datas>();

        Date T = null;
        GregorianCalendar calendar = new GregorianCalendar();
        Calendar data = new GregorianCalendar();
        Date hoje = data.getTime();
        int dia = 1;

        data.set(ano, mes, dia);

        int diaMaximo = data.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (dia = 1; dia <= diaMaximo; dia++) {
            data.set(Calendar.DAY_OF_MONTH, dia);
            int diaDaSemana = data.get(Calendar.DAY_OF_WEEK);
            if ((diaDaSemana == Calendar.WEDNESDAY) || (diaDaSemana == Calendar.THURSDAY)) {//1 = terça e 2 = quarta
                T = data.getTime();
                // if (hoje.after(T)) {//before = antes - after = depois
                int diaDaSemanaE = data.get(Calendar.DAY_OF_WEEK);
                String formato = "dd/MM/yyyy";
                SimpleDateFormat formatter = new SimpleDateFormat(formato);
                String dateRetorn = formatter.format(T);
                Datas dts = new Datas();
                String g = getDiaDaSemana(diaDaSemana);
                dts.setDatas(dateRetorn);
                dts.setDia(g);
                datas.add(dts);
                // }
            }
        }

        return datas;
    }

    public static ArrayList<Datas> getDiasDeDeusQuaQuiAnoSeguinte(int mes, int ano) {

        Set<Integer> weeks = new HashSet<Integer>();
        ArrayList<Datas> datas = new ArrayList<Datas>();
        ArrayList<Datas> dataCorreta = new ArrayList<Datas>();

        Date T = null;
        GregorianCalendar calendar = new GregorianCalendar();
        Calendar data = new GregorianCalendar();
        Date hoje = data.getTime();
        int dia = 1;

        data.set(ano, mes, dia);

        int diaMaximo = data.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (dia = 1; dia <= diaMaximo; dia++) {
            data.set(Calendar.DAY_OF_MONTH, dia);
            int diaDaSemana = data.get(Calendar.DAY_OF_WEEK);
            if ((diaDaSemana == Calendar.WEDNESDAY) || (diaDaSemana == Calendar.THURSDAY)) {//1 = terça e 2 = quarta
                T = data.getTime();
                // if (hoje.after(T)) {//before = antes - after = depois
                int diaDaSemanaE = data.get(Calendar.DAY_OF_WEEK);
                String formato = "dd/MM/yyyy";
                SimpleDateFormat formatter = new SimpleDateFormat(formato);
                String dateRetorn = formatter.format(T);
                Datas dts = new Datas();
                String g = getDiaDaSemana(diaDaSemana);
                dts.setDatas(dateRetorn);
                dts.setDia(g);
                datas.add(dts);
                // }
            }
        }

        return datas;
    }

    public static String getMesesdoAno(int mesEscolhido) {
        String viewMesEscolhido = "";
        if (mesEscolhido == 0) {
            viewMesEscolhido = "Janeiro";
        } else if (mesEscolhido == 1) {
            viewMesEscolhido = "Fevereiro";
        } else if (mesEscolhido == 2) {
            viewMesEscolhido = "Março";
        } else if (mesEscolhido == 3) {
            viewMesEscolhido = "Abril";
        } else if (mesEscolhido == 4) {
            viewMesEscolhido = "Maio";
        } else if (mesEscolhido == 5) {
            viewMesEscolhido = "Junho";
        } else if (mesEscolhido == 6) {
            viewMesEscolhido = "Julho";
        } else if (mesEscolhido == 7) {
            viewMesEscolhido = "Agosto";
        } else if (mesEscolhido == 8) {
            viewMesEscolhido = "Setembro";
        } else if (mesEscolhido == 9) {
            viewMesEscolhido = "Outubro";
        } else if (mesEscolhido == 10) {
            viewMesEscolhido = "Novembro";
        } else if (mesEscolhido == 11) {
            viewMesEscolhido = "Dezembro";
        }

        return viewMesEscolhido;
    }

    public static String getDiaDaSemana(int dia) {
        String diaDaSemana = "";

        if (dia == 1) {
            diaDaSemana = "Domingo";
        } else if (dia == 2) {
            diaDaSemana = "Segunda-Feira";
        } else if (dia == 3) {
            diaDaSemana = "Terca-Feira";
        } else if (dia == 4) {
            diaDaSemana = "Quarta-Feira";
        } else if (dia == 5) {
            diaDaSemana = "Quinta-Feira";
        } else if (dia == 6) {
            diaDaSemana = "Sexta-Feira";
        } else if (dia == 7) {
            diaDaSemana = "Sabado";
        }

        return diaDaSemana;
    }

    public static ArrayList<MesesAno> getMesesDoAno(int mes) {
        ArrayList<MesesAno> mesesAno = new ArrayList<MesesAno>();

        if (mes == 0) {

            MesesAno w = new MesesAno();
            w.setMesesDoAno("Janeiro");
            w.setIdMesesDoAno(0);
            mesesAno.add(w);

            MesesAno w1 = new MesesAno();
            w1.setMesesDoAno("Fevereiro");
            w1.setIdMesesDoAno(1);
            mesesAno.add(w1);

            MesesAno w2 = new MesesAno();
            w2.setMesesDoAno("Março");
            w2.setIdMesesDoAno(2);
            mesesAno.add(w2);

            MesesAno w3 = new MesesAno();
            w3.setMesesDoAno("Abril");
            w3.setIdMesesDoAno(3);
            mesesAno.add(w3);

            MesesAno w4 = new MesesAno();
            w4.setMesesDoAno("Maio");
            w4.setIdMesesDoAno(4);
            mesesAno.add(w4);

            MesesAno w5 = new MesesAno();
            w5.setMesesDoAno("Junho");
            w5.setIdMesesDoAno(5);
            mesesAno.add(w5);

        } else if (mes == 1) {

            MesesAno w1 = new MesesAno();
            w1.setMesesDoAno("Fevereiro");
            w1.setIdMesesDoAno(1);
            mesesAno.add(w1);

            MesesAno w2 = new MesesAno();
            w2.setMesesDoAno("Março");
            w2.setIdMesesDoAno(2);
            mesesAno.add(w2);

            MesesAno w3 = new MesesAno();
            w3.setMesesDoAno("Abril");
            w3.setIdMesesDoAno(3);
            mesesAno.add(w3);

            MesesAno w4 = new MesesAno();
            w4.setMesesDoAno("Maio");
            w4.setIdMesesDoAno(4);
            mesesAno.add(w4);

            MesesAno w5 = new MesesAno();
            w5.setMesesDoAno("Junho");
            w5.setIdMesesDoAno(5);
            mesesAno.add(w5);

            MesesAno w6 = new MesesAno();
            w6.setMesesDoAno("Julho");
            w6.setIdMesesDoAno(6);
            mesesAno.add(w6);

        } else if (mes == 2) {

            MesesAno w2 = new MesesAno();
            w2.setMesesDoAno("Março");
            w2.setIdMesesDoAno(2);
            mesesAno.add(w2);

            MesesAno w3 = new MesesAno();
            w3.setMesesDoAno("Abril");
            w3.setIdMesesDoAno(3);
            mesesAno.add(w3);

            MesesAno w4 = new MesesAno();
            w4.setMesesDoAno("Maio");
            w4.setIdMesesDoAno(4);
            mesesAno.add(w4);

            MesesAno w5 = new MesesAno();
            w5.setMesesDoAno("Junho");
            w5.setIdMesesDoAno(5);
            mesesAno.add(w5);

            MesesAno w6 = new MesesAno();
            w6.setMesesDoAno("Julho");
            w6.setIdMesesDoAno(6);
            mesesAno.add(w6);

            MesesAno w7 = new MesesAno();
            w7.setMesesDoAno("Agosto");
            w7.setIdMesesDoAno(7);
            mesesAno.add(w7);

        } else if (mes == 3) {

            MesesAno w3 = new MesesAno();
            w3.setMesesDoAno("Abril");
            w3.setIdMesesDoAno(3);
            mesesAno.add(w3);

            MesesAno w4 = new MesesAno();
            w4.setMesesDoAno("Maio");
            w4.setIdMesesDoAno(4);
            mesesAno.add(w4);

            MesesAno w5 = new MesesAno();
            w5.setMesesDoAno("Junho");
            w5.setIdMesesDoAno(5);
            mesesAno.add(w5);

            MesesAno w6 = new MesesAno();
            w6.setMesesDoAno("Julho");
            w6.setIdMesesDoAno(6);
            mesesAno.add(w6);

            MesesAno w7 = new MesesAno();
            w7.setMesesDoAno("Agosto");
            w7.setIdMesesDoAno(7);
            mesesAno.add(w7);

            MesesAno w8 = new MesesAno();
            w8.setMesesDoAno("Setembro");
            w8.setIdMesesDoAno(8);
            mesesAno.add(w8);

        } else if (mes == 4) {

            MesesAno w4 = new MesesAno();
            w4.setMesesDoAno("Maio");
            w4.setIdMesesDoAno(4);
            mesesAno.add(w4);

            MesesAno w5 = new MesesAno();
            w5.setMesesDoAno("Junho");
            w5.setIdMesesDoAno(5);
            mesesAno.add(w5);

            MesesAno w6 = new MesesAno();
            w6.setMesesDoAno("Julho");
            w6.setIdMesesDoAno(6);
            mesesAno.add(w6);

            MesesAno w7 = new MesesAno();
            w7.setMesesDoAno("Agosto");
            w7.setIdMesesDoAno(7);
            mesesAno.add(w7);

            MesesAno w8 = new MesesAno();
            w8.setMesesDoAno("Setembro");
            w8.setIdMesesDoAno(8);
            mesesAno.add(w8);

            MesesAno w9 = new MesesAno();
            w9.setMesesDoAno("Outubro");
            w9.setIdMesesDoAno(9);
            mesesAno.add(w9);

        } else if (mes == 5) {

            MesesAno w5 = new MesesAno();
            w5.setMesesDoAno("Junho");
            w5.setIdMesesDoAno(5);
            mesesAno.add(w5);

            MesesAno w6 = new MesesAno();
            w6.setMesesDoAno("Julho");
            w6.setIdMesesDoAno(6);
            mesesAno.add(w6);

            MesesAno w7 = new MesesAno();
            w7.setMesesDoAno("Agosto");
            w7.setIdMesesDoAno(7);
            mesesAno.add(w7);

            MesesAno w8 = new MesesAno();
            w8.setMesesDoAno("Setembro");
            w8.setIdMesesDoAno(8);
            mesesAno.add(w8);

            MesesAno w9 = new MesesAno();
            w9.setMesesDoAno("Outubro");
            w9.setIdMesesDoAno(9);
            mesesAno.add(w9);

            MesesAno w1a = new MesesAno();
            w1a.setMesesDoAno("Novembro");
            w1a.setIdMesesDoAno(10);
            mesesAno.add(w1a);

        } else if (mes == 6) {

            MesesAno w6 = new MesesAno();
            w6.setMesesDoAno("Julho");
            w6.setIdMesesDoAno(6);
            mesesAno.add(w6);

            MesesAno w7 = new MesesAno();
            w7.setMesesDoAno("Agosto");
            w7.setIdMesesDoAno(7);
            mesesAno.add(w7);

            MesesAno w8 = new MesesAno();
            w8.setMesesDoAno("Setembro");
            w8.setIdMesesDoAno(8);
            mesesAno.add(w8);

            MesesAno w9 = new MesesAno();
            w9.setMesesDoAno("Outubro");
            w9.setIdMesesDoAno(9);
            mesesAno.add(w9);

            MesesAno w1a = new MesesAno();
            w1a.setMesesDoAno("Novembro");
            w1a.setIdMesesDoAno(10);
            mesesAno.add(w1a);

            MesesAno w1b = new MesesAno();
            w1b.setMesesDoAno("Dezembro");
            w1b.setIdMesesDoAno(11);
            mesesAno.add(w1b);

        } else if (mes == 7) {

            MesesAno w7 = new MesesAno();
            w7.setMesesDoAno("Agosto");
            w7.setIdMesesDoAno(7);
            mesesAno.add(w7);

            MesesAno w8 = new MesesAno();
            w8.setMesesDoAno("Setembro");
            w8.setIdMesesDoAno(8);
            mesesAno.add(w8);

            MesesAno w9 = new MesesAno();
            w9.setMesesDoAno("Outubro");
            w9.setIdMesesDoAno(9);
            mesesAno.add(w9);

            MesesAno w1a = new MesesAno();
            w1a.setMesesDoAno("Novembro");
            w1a.setIdMesesDoAno(10);
            mesesAno.add(w1a);

            MesesAno w1b = new MesesAno();
            w1b.setMesesDoAno("Dezembro");
            w1b.setIdMesesDoAno(11);
            mesesAno.add(w1b);

            MesesAno w = new MesesAno();
            w.setMesesDoAno("Janeiro");
            w.setIdMesesDoAno(0);
            mesesAno.add(w);

        } else if (mes == 8) {

            MesesAno w8 = new MesesAno();
            w8.setMesesDoAno("Setembro");
            w8.setIdMesesDoAno(8);
            mesesAno.add(w8);

            MesesAno w9 = new MesesAno();
            w9.setMesesDoAno("Outubro");
            w9.setIdMesesDoAno(9);
            mesesAno.add(w9);

            MesesAno w1a = new MesesAno();
            w1a.setMesesDoAno("Novembro");
            w1a.setIdMesesDoAno(10);
            mesesAno.add(w1a);

            MesesAno w1b = new MesesAno();
            w1b.setMesesDoAno("Dezembro");
            w1b.setIdMesesDoAno(11);
            mesesAno.add(w1b);

            MesesAno w = new MesesAno();
            w.setMesesDoAno("Janeiro");
            w.setIdMesesDoAno(0);
            mesesAno.add(w);

            MesesAno w1 = new MesesAno();
            w1.setMesesDoAno("Fevereiro");
            w1.setIdMesesDoAno(1);
            mesesAno.add(w1);

        } else if (mes == 9) {

            MesesAno w9 = new MesesAno();
            w9.setMesesDoAno("Outubro");
            w9.setIdMesesDoAno(9);
            mesesAno.add(w9);

            MesesAno w1a = new MesesAno();
            w1a.setMesesDoAno("Novembro");
            w1a.setIdMesesDoAno(10);
            mesesAno.add(w1a);

            MesesAno w1b = new MesesAno();
            w1b.setMesesDoAno("Dezembro");
            w1b.setIdMesesDoAno(11);
            mesesAno.add(w1b);

            MesesAno w = new MesesAno();
            w.setMesesDoAno("Janeiro");
            w.setIdMesesDoAno(0);
            mesesAno.add(w);

            MesesAno w1 = new MesesAno();
            w1.setMesesDoAno("Fevereiro");
            w1.setIdMesesDoAno(1);
            mesesAno.add(w1);

            MesesAno w2 = new MesesAno();
            w2.setMesesDoAno("Março");
            w2.setIdMesesDoAno(2);
            mesesAno.add(w2);

        } else if (mes == 10) {

            MesesAno w1a = new MesesAno();
            w1a.setMesesDoAno("Novembro");
            w1a.setIdMesesDoAno(10);
            mesesAno.add(w1a);

            MesesAno w1b = new MesesAno();
            w1b.setMesesDoAno("Dezembro");
            w1b.setIdMesesDoAno(11);
            mesesAno.add(w1b);

            MesesAno w = new MesesAno();
            w.setMesesDoAno("Janeiro");
            w.setIdMesesDoAno(0);
            mesesAno.add(w);

            MesesAno w1 = new MesesAno();
            w1.setMesesDoAno("Fevereiro");
            w1.setIdMesesDoAno(1);
            mesesAno.add(w1);

            MesesAno w2 = new MesesAno();
            w2.setMesesDoAno("Março");
            w2.setIdMesesDoAno(2);
            mesesAno.add(w2);

            MesesAno w3 = new MesesAno();
            w3.setMesesDoAno("Abril");
            w3.setIdMesesDoAno(3);
            mesesAno.add(w3);

        } else if (mes == 11) {

            MesesAno w1b = new MesesAno();
            w1b.setMesesDoAno("Dezembro");
            w1b.setIdMesesDoAno(11);
            mesesAno.add(w1b);

            MesesAno w = new MesesAno();
            w.setMesesDoAno("Janeiro");
            w.setIdMesesDoAno(0);
            mesesAno.add(w);

            MesesAno w1 = new MesesAno();
            w1.setMesesDoAno("Fevereiro");
            w1.setIdMesesDoAno(1);
            mesesAno.add(w1);

            MesesAno w2 = new MesesAno();
            w2.setMesesDoAno("Março");
            w2.setIdMesesDoAno(2);
            mesesAno.add(w2);

            MesesAno w3 = new MesesAno();
            w3.setMesesDoAno("Abril");
            w3.setIdMesesDoAno(3);
            mesesAno.add(w3);

            MesesAno w4 = new MesesAno();
            w4.setMesesDoAno("Maio");
            w4.setIdMesesDoAno(4);
            mesesAno.add(w4);
        }


        return mesesAno;
    }
*/
    /*CUSTOMIZANDO*/
    public static boolean validaIdentificador2(String I) {
        boolean n = false;
        if (I.startsWith("A0")) {
            n = true;
        } else {
            if (I.startsWith("O0")) {
                n = true;
            } else {
                if (I.startsWith("R0")) {
                    n = true;
                } else {
                    if (I.startsWith("E0")) {
                        n = true;
                    } else {
                        if (I.startsWith("P0")) {
                            n = true;
                        } else {
                            n = false;
                        }
                    }
                }
            }
        }
        return n;
    }
//RETORNA TIPO DE IDENTIFICADOR

    public static String retornaTypeIdentificador(String ident) {
        String aux = "";
        if (ident.startsWith("A0")) {
            aux = "A0";
        } else {
            if (ident.startsWith("O0")) {
                aux = "O0";
            } else {
                if (ident.startsWith("R0")) {
                    aux = "R0";
                } else {
                    if (ident.startsWith("E0")) {
                        aux = "E0";
                    } else {
                        if (ident.startsWith("P0")) {
                            aux = "P0";
                        }
                    }
                }
            }
        }
        return aux;

    }

    public static String removeSpaces(String s) {
        StringTokenizer st = new StringTokenizer(s, " ", false);
        String t = "";
        while (st.hasMoreElements()) {
            t += st.nextElement();
        }
        return t;
    }

    public static void removieContentFile() {
        // uma instância de RandomAccessFile para leitura e escrita
        try {
            RandomAccessFile arquivo =
                    new RandomAccessFile("C:\\AgendaJava\\agenda1.txt", "rw");

            // vamos excluir todo o conteúdo do arquivo
            arquivo.setLength(0);

            arquivo.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        System.exit(0);
    }


    /*para clcular a idade entrando com data
    convertendo string em data
    String formato = "dd/MM/yyyy";
    SimpleDateFormat formatter = new SimpleDateFormat(formato);
    Date date = (Date)formatter.parse(dataBanco); 
    int idade = MetodoAuxiliar.calcIdade(date);
     */
    public static int calcIdade(Date dataNasc) {
        Date hoje = new Date();
        Calendar cal = Calendar.getInstance();

        cal.setTime(hoje);
        int day1 = cal.get(Calendar.DAY_OF_YEAR);
        int ano1 = cal.get(Calendar.YEAR);

        cal.setTime(dataNasc);
        int day2 = cal.get(Calendar.DAY_OF_YEAR);
        int ano2 = cal.get(Calendar.YEAR);

        int nAno = ano1 - ano2;

        if (day1 < day2) {
            nAno--; //Ainda não completou aniversario esse ano.  
        }
        return nAno;
    }

    // import java.util.Calendar;  
    public static String retornaDiaSemana(Date dataNasc) {
        String msg = "";
        int dia_semana;

        //Calendar data = Calendar.getInstance();  
        Calendar data = Calendar.getInstance();
        data.setTime(dataNasc);
        dia_semana = data.get(Calendar.DAY_OF_WEEK);

        switch (dia_semana) {
            case 1:
                msg = "Domingo";
                break;
            case 2:
                msg = "Segunda";
                break;
            case 3:
                msg = "Terca";
                break;
            case 4:
                msg = "Quarta";
                break;
            case 5:
                msg = "Quinta";
                break;
            case 6:
                msg = "Sexta";
                break;
            case 7:
                msg = "Sabado";
                break;
        }
        return msg;

    }
    /*Outros métodos muito importantes da classe java.util.Calendar são: before() e 
    after()(depois). before()(antes) nos permite saber se uma determinada data é anterior a outra data. 
    after() é o inverso, retorna se uma data é posterior a outra data. Tem a seguinte 
    sintaxe: 
    
    import java.util.Calendar; 
    class JavaIniciante { 
    public static void main (String args[]){ 
    Calendar data1 = Calendar.getInstance(); 
    data1.set(Calendar.DAY_OF_MONTH, 1; 
    data1.set(Calendar.MONTH, 10); 
    data1.set(Calendar.YEAR, 2005); 
    Calendar data2 = Calendar.getInstance(); 
    data2.set(Calendar.DAY_OF_MONTH, 12); 
    data2.set(Calendar.MONTH, ; 
    data2.set(Calendar.YEAR, 2007); 
    if (data1.before(data2)){ 
    System.out.println("data1 é anterior a data2"); 
    } 
    else{ 
    System.out.println("data1 não é anterior a data2"); 
    } 
    } 
    } */

    public static boolean dataPassada(Date dataVerifik) {
        boolean msg = false;

        Date hoje = new Date();
        Calendar D1 = Calendar.getInstance();
        Calendar D2 = Calendar.getInstance();
        D1.setTime(hoje);
        D2.setTime(dataVerifik);

        if (D1.before(D2)) {
            msg = true;
        } else {
            msg = false;
        }


        return msg;

    }
    private static String nomeArquivo;
    @SuppressWarnings("unused")
	private static BufferedWriter arqSaida;
    @SuppressWarnings("unused")
	private static Scanner arqEntrada;

    public static String getNomeArquivo() {
        return nomeArquivo;
    }

    public static void setNomeArquivo(String NomeArquivo) {
        nomeArquivo = NomeArquivo;
    }

    @SuppressWarnings("unused")
	private static void AbreArquivo() {

        if (!getNomeArquivo().isEmpty()) {
            File arq = new File("C:\\AgendaJava\\agenda1.txt");
            if (arq.exists()) {
                try {
                    arqSaida = new BufferedWriter(new FileWriter(arq, true));
                } catch (IOException ex) {
                }



            } else {
                try {

                    arqSaida = new BufferedWriter(new FileWriter(arq, false));
                } catch (IOException ex) {
                }

            }
        } else {
            System.out.println("Nome do arquivo não preenchido");
        }


    }

    public static String getHojeFormat() {
        Date hoje = new Date();
        String formato = "dd/MM/yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        String data = formatter.format(hoje);
        return data;
    }

    public static String getHoje() {
        String diaf = null;
        String mesf = null;
        String retorno = null;
        Calendar calendar = new GregorianCalendar();
        Date hoje = new Date();
        calendar.setTime(hoje);
        int semana = calendar.get(Calendar.DAY_OF_WEEK);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int ano = calendar.get(Calendar.YEAR);

        // semana  
        switch (semana) {
            case 1:
                diaf = "Domingo";
                break;
            case 2:
                diaf = "Segunda";
                break;
            case 3:
                diaf = "Terça";
                break;
            case 4:
                diaf = "Quarta";
                break;
            case 5:
                diaf = "Quinta";
                break;
            case 6:
                diaf = "Sexta";
                break;
            case 7:
                diaf = "Sábado";
                break;
        }
        // mês  
        switch (mes) {
            case 0:
                mesf = "Janeiro";
                break;
            case 1:
                mesf = "Fevereiro";
                break;
            case 2:
                mesf = "Março";
                break;
            case 3:
                mesf = "Abril";
                break;
            case 4:
                mesf = "Maio";
                break;
            case 5:
                mesf = "Junho";
                break;
            case 6:
                mesf = "Julho";
                break;
            case 7:
                mesf = "Agosto";
                break;
            case 8:
                mesf = "Setembro";
                break;
            case 9:
                mesf = "Outubro";
                break;
            case 10:
                mesf = "Novembro";
                break;
            case 11:
                mesf = "Dezembro";
                break;
        }

        retorno = diaf + ", " + dia + " de " + mesf + ", de " + ano;
        return retorno;
    }

    public static String subtraiHora(String hora, String hora2) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));

        long min_1 = getMinutos(hora, formatter);
        long min_2 = getMinutos(hora2, formatter);
        long result = (min_1 - min_2) * 60 * 1000;
        Date data = new Date(result);
        return formatter.format(data);
    }

    public static String getDATA(String data) {
        String diaf = null;
        String mesf = null;
        String retorno = null;
        Calendar calendar = new GregorianCalendar();
        Date hoje = new Date();
        Date DATA = hoje;
        String formato = "dd/MM/yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        try {
            DATA = (Date) formatter.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(MetodoAuxiliar.class.getName()).log(Level.SEVERE, null, ex);
        }



        calendar.setTime(DATA);
        int semana = calendar.get(Calendar.DAY_OF_WEEK);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int ano = calendar.get(Calendar.YEAR);

        // semana  
        switch (semana) {
            case 1:
                diaf = "Domingo";
                break;
            case 2:
                diaf = "Segunda";
                break;
            case 3:
                diaf = "Terça";
                break;
            case 4:
                diaf = "Quarta";
                break;
            case 5:
                diaf = "Quinta";
                break;
            case 6:
                diaf = "Sexta";
                break;
            case 7:
                diaf = "Sábado";
                break;
        }
        // mês  
        switch (mes) {
            case 0:
                mesf = "Janeiro";
                break;
            case 1:
                mesf = "Fevereiro";
                break;
            case 2:
                mesf = "Março";
                break;
            case 3:
                mesf = "Abril";
                break;
            case 4:
                mesf = "Maio";
                break;
            case 5:
                mesf = "Junho";
                break;
            case 6:
                mesf = "Julho";
                break;
            case 7:
                mesf = "Agosto";
                break;
            case 8:
                mesf = "Setembro";
                break;
            case 9:
                mesf = "Outubro";
                break;
            case 10:
                mesf = "Novembro";
                break;
            case 11:
                mesf = "Dezembro";
                break;
        }

        retorno = diaf + ", " + dia + " de " + mesf + ", de " + ano;
        return retorno;
    }

    private static long getMinutos(String hora, SimpleDateFormat formatter) {
        Date data;
        try {
            data = formatter.parse(hora);
        } catch (ParseException e) {
            return 0;
        }
        long minutos = data.getTime() / 1000 / 60;
        return minutos;
    }

    /*
     * Olha, tem muito blá, blá, blá, de critica desnecessária aqui, o cara fez, ta tentando ajudar... 
    
    Bom, eu Fiz os 2 únicos códigos que estavam aqui e sinceramente o único que fez o que foi perguntado no fórum foi o do brunoambrozio... O código do miojo não acumula à hora, só soma datas... E é só... É pequeno, mas não faz o que deveria... 20:00 + 10:00 = 30:00 e não 06:00...
    
    Então pra acabar com a novela:
    
    public void calcular(){          
    System.out.println( obterTempo(obterMinutos("01:30") + obterMinutos("02:30")) );  
    }  
    
    public static long obterMinutos(String hora1) {  
    String[] time = hora1.split(":");  
    try {  
    return Integer.parseInt(time[1]) + (Integer.parseInt(time[0])*60);  
    } catch (NumberFormatException e) {  
    return 0;  
    }  
    }  
    
    public static String obterTempo(long minutos){  
    return String.format ("%02d:%02d", (minutos / 60), (minutos % 60));  
    }  
    
     */
    public static void deletFile() {
        boolean success = (new File("C:\\AgendaJava\\agenda1.txt")).delete();
        if (!success) {
            System.out.print("Falhou deletar \n");
        }

    }

    public static void createFile() {
        try {
            boolean success = (new File("C:\\AgendaJava\\agenda1.txt")).createNewFile();
            if (!success) {
                System.out.print("Falhou criar \n");
            }
        } catch (IOException ex) {
            Logger.getLogger(MetodoAuxiliar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void renameFile() {
        // File (or directory) with old name
        File file = new File("C:\\AgendaJava\\agenda2.txt");

// File (or directory) with new name
        File file2 = new File("C:\\AgendaJava\\agenda1.txt");
// Rename file (or directory)
        boolean success = file.renameTo(file2);
        if (!success) {
            System.out.print("Falhou \n");
        }

    }

    public static void removieContentFileII() {
        // uma instância de RandomAccessFile para leitura e escrita
        try {
            RandomAccessFile arquivo =
                    new RandomAccessFile("C:\\AgendaJava\\agenda1.txt", "rw");

            // vamos excluir todo o conteúdo do arquivo
            arquivo.setLength(0);

            arquivo.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        System.exit(0);
    }

    public static void copyFile() throws FileNotFoundException, IOException {
        String linha12 = null;
        String element = "";
        ArrayList<String> comp12 = new ArrayList<String>();


        BufferedReader reader = null;
        BufferedWriter rout = null;

        try {
            reader = new BufferedReader(new FileReader("C:\\AgendaJava\\agenda2.txt"));
            rout = new BufferedWriter(new FileWriter("C:\\AgendaJava\\agenda1.txt", true));


            while ((linha12 = reader.readLine()) != null) {
                System.out.println(linha12);
                comp12.add(linha12);
            }

            removieContentFileII();

            Iterator<String> itr = comp12.iterator();
            while (itr.hasNext()) {
                element = itr.next();

            }
            rout.write(element + "\n");

            removieContentFile();

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (rout != null) {
                rout.close();
            }
        }


    }

    @SuppressWarnings("unused")
	public static void Writingfile(ArrayList<String> array) throws FileNotFoundException, IOException {
        String linha23 = null;
        String element = "";
        File arq = new File("C:/AgendaJava/agenda1.txt");
        BufferedWriter rout = null;
        try {

            rout = new BufferedWriter(new FileWriter(arq, false));

            Iterator<String> itr = array.iterator();
            while (itr.hasNext()) {
                element = itr.next();
                rout.write(element + "\n");

            }

        } finally {
            if (rout != null) {
                rout.close();
            }
        }


    }

    public static void Writingfile2(ArrayList<String> array) throws FileNotFoundException, IOException {

        String element = "";
        File arq = new File("C:/AgendaJava/agenda1.txt");
        BufferedWriter rout = null;
        try {

            rout = new BufferedWriter(new FileWriter(arq, true));

            Iterator<String> itr = array.iterator();
            while (itr.hasNext()) {
                element = itr.next();
                rout.write(element + "\n");

            }

        } finally {
            if (rout != null) {
                rout.close();
            }
        }


    }

    @SuppressWarnings("resource")
	public static ArrayList<String> lerArquivoPrincipal() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("C:/AgendaJava/agenda1.txt"));
            while ((linha = reader.readLine()) != null) {
                comp.add(linha);
            }
        } catch (IOException e1) {
            
        }
        return comp;
    }

    @SuppressWarnings("resource")
	public static ArrayList<String> lerArquivoPrincipalImport() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("C:/AgendaJava/agenda1.txt"));
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
                comp.add(linha);
            }
        } catch (IOException e1) {
            
        }
        return comp;
    }

    public static byte[] gerarHash(String frase, String algoritmo) {
        try {
            MessageDigest md = MessageDigest.getInstance(algoritmo);
            md.update(frase.getBytes());
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String stringHexa(byte[] bytes) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
            int parteBaixa = bytes[i] & 0xf;
            if (parteAlta == 0) {
                s.append('0');
            }
            s.append(Integer.toHexString(parteAlta | parteBaixa));
        }
        return s.toString();
    }
    //usar :: String md5 = stringHexa(gerarHash("a", "MD5"));
    
    
     public static String geraMD5(String frase) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(frase.getBytes());
        byte[] hashMd5 = md.digest();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < hashMd5.length; i++) {
            int parteAlta = ((hashMd5[i] >> 4) & 0xf) << 4;
            int parteBaixa = hashMd5[i] & 0xf;
            if (parteAlta == 0) {
                s.append('0');
            }
            s.append(Integer.toHexString(parteAlta | parteBaixa));
        }
        return s.toString();
    }
    
    
    
    
    
}//ultimo
