/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celebro;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author mfernandes
 */
public class Celebro {

    public static HashMap<String, Object> MEMORIA = new HashMap<>();

    static String basica
            = "classLoader=/home/mfernandes/NetBeansProjects/Reflexon/class/\n"
            + "REFERENCIA1=@#$%->\n"
            + "REFERENCIA2=<~}])\n"
            + "template=package reflexon; public class NOME extends Template {;public String getTipo() {; return \"TIPO\";};public String getNomeReal(){; return \"NOME_REAL\";};CONTENT ;}\n"
            + "template.conceito=package reflexon; public class NOME extends Template {;public String getTipo() {; return \"conceito\";};public String getNomeReal(){; return \"NOME_REAL\";};public String[] getVerbetes(){;IN;};public String[] getSignificados(String[] verbetes){;OUT;};}\n"
            + "template.metodo=package reflexon; public class NOME extends Template {;public String getTipo() {; return \"metodo\";};public String getNomeReal(){; return \"NOME_REAL\";};public void setData(Object data){;IN;};public Object getData(){;OUT;};public void run(){;RUN;};}\n"
            + "template.coisa=package reflexon; public class NOME extends Template {;public String getTipo() {; return \"coisa\";};public String getNomeReal(){; return \"NOME_REAL\";}; public String[] getClasses(){;CLASS;};public Method[] getMetodos(){;METODOS;};public Field[] getAtributos(){;ATRIBUTOS;};}";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        // TODO code application logic here
        String file = "/home/mfernandes/teste.txt";

        File f = new File(file);
        if (!f.exists()) {
          f.createNewFile();
//        } else {
//            Files.copy(f.toPath(), new File(file + ".old").toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        Properties map = new Properties();

        for (String string : basica.split("\n")) {
            String[] split = string.split("=");
            map.put(split[0], split[1]);
        }

        map.load(new FileInputStream(file));

        MainView view = new MainView(MEMORIA, map, file);
        MEMORIA.put("base.mainview", view);
        view.setVisible(true);

//        
//        Scanner sc = new Scanner(System.in);
//
//        map.entrySet().forEach((t) -> {
//            System.out.println(t.getKey() + " -> " + t.getValue());
//        });
//
//        while (sc.hasNextLine()) {
//
//            String key = sc.nextLine();
//
//            //conceito ou tarefa
//            boolean isTarefa = key.startsWith("T");
//            key = key.substring(1);
//
//            ///tarefa: add funcao | executar com entrada e salvar na saida + rodar saida
//            if (isTarefa) {
//                boolean isNova = key.startsWith("A");
//                key = key.substring(1);
//                String nome = replaceIf(key + ".nome", map.getProperty(key + ".nome"), map);
//                String in = replaceIf(key + ".in", map.getProperty(key + ".in"), map);
//                String out = replaceIf(key + ".out", map.getProperty(key + ".out"), map);
//                if (isNova) {
//
//                    String template = replaceIf(key + ".template", map.getProperty(key + ".template"), map);
//
//                    String run = replaceIf(key + ".run", map.getProperty(key + ".run"), map);
//
//                    template = template.replace("NOME", nome);
//                    template = template.replace("IN", in);
//                    template = template.replace("OUT", out);
//                    template = template.replace("RUN", run);
//
//                    Runtime.getRuntime().exec(
//                            ("java,reflexon.Reflexon,decode," + nome + ","
//                                    + Base64.getEncoder().encodeToString(template.getBytes())).split(","), null, new File("/home/mfernandes/NetBeansProjects/Reflexon/class/"));
//                } else {
//
//                    Template t = getTemplate(nome);
//
//                    t._c(MEMORIA, map, fw, file);
//
//                    if (t.getTipo().equals("conceito")) {
//
//                        String[] inp = null;
//                        String[] verbetes = (String[]) t.getClass().getMethod("getVerbetes", (Class<?>) null).invoke(t, (Object) null);
//                        String[] significados = (String[]) t.getClass().getMethod("getSignificados", String[].class).invoke(t, new Object[]{inp});
//
//                    } else if (t.getTipo().equals("metodo")) {
//
//                        t.getClass().getMethod("setData", Object.class).invoke(t, in);
//                        t.getClass().getMethod("run", (Class<?>) null).invoke(t, (Object) null);
//                        Object retorno = t.getClass().getMethod("getData", (Class<?>) null).invoke(t, (Object) null);
//
//                        System.out.println("REsultado: " + retorno);
//
//                    } else if (t.getTipo().equals("coisa")) {
//
//                        String[] classes = (String[]) t.getClass().getMethod("getClasses", (Class<?>) null).invoke(t, (Object) null);
//                        Method[] metodos = (Method[]) t.getClass().getMethod("getMetodos", (Class<?>) null).invoke(t, (Object) null);
//                        Field[] atributos = (Field[]) t.getClass().getMethod("getAtributos", (Class<?>) null).invoke(t, (Object) null);
//
//                    } else {
//                        ////resolver com outra classeMETODO oque fazer com ele
//                        Template t2 = getTemplate(nome);
//
//                        t2.getClass().getMethod("setData", Object.class).invoke(t2, t);
//                        t2.getClass().getMethod("run", (Class<?>) null).invoke(t, (Object) null);
//                        Object retorno = t.getClass().getMethod("getData", (Class<?>) null).invoke(t, (Object) null);
//
//                    }
//
//                }
//
//            } else {
//
//                System.out.println("Oque fazer com " + key + "?");
//                String val = sc.nextLine();
//                if (key.startsWith("@")) {
//                    System.err.println("valor subs para referencia");
//                    val = val.replace("\\@", REFERENCIA1);
//                    val = val.replace("@/", REFERENCIA2);
//                }
//
//                map.put(key, val);
//
//                map.entrySet().forEach((t) -> {
//                    System.out.println(t.getKey() + " -> " + t.getValue());
//                });
//
//                map.store(fw, file);
//            }
//        }
    }

//    static String replaceIf(String key, String val, Hashtable h) {
//        if (key.startsWith("@")) {
//            ArrayList<String> ped = new ArrayList<>();
//            String[] split = val.split(REFERENCIA1);
//            for (String string : split) {
//                if (string.contains(REFERENCIA2)) {
//                    String[] split1 = string.split(REFERENCIA2);
//                    ped.add(h.get(split1[0]) + split1[1]);
//                } else {
//                    ped.add(string);
//                }
//            }
//        }
//        return val;
//    }
//
//    static Template getTemplate(String nameClass) throws Exception {
//        // Create a File object on the root of the directory containing the class file
//        File file = new File("/home/mfernandes/NetBeansProjects/Reflexon/class/");
//
//        // Convert File to a URL
//        URL url = file.toURI().toURL();          // file:/c:/myclasses/
//        URL[] urls = new URL[]{url};
//
//        // Create a new class loader with the directory
//        ClassLoader cl = new URLClassLoader(urls);
//
//        // Load in the class; MyClass.class should be located in
//        // the directory file:/c:/myclasses/com/mycompany
//        Class cls = cl.loadClass("reflexon." + nameClass);
//        return (Template) cls.newInstance();
//
//    }
}
