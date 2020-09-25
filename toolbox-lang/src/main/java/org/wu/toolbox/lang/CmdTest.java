package org.wu.toolbox.lang;

/**
 * @author wusq
 * @date 2020/9/22
 */
public class CmdTest {

    public static void main(String[] args) {
        String path = "D:\\test\\ffmpeg.bat";
        Runtime run = Runtime.getRuntime();
        try {
            // run.exec("cmd /k shutdown -s -t 3600");
            Process process = run.exec("cmd.exe /k start " + path);
            /*InputStream in = process.getInputStream();
            while (in.read() != -1) {
                System.out.println(in.read());
            }
            in.close();
            process.waitFor();*/
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*public static void main(String[] args) {
        String batPath = "D:/test/ffmpeg.bat"; // 把你的bat脚本路径写在这里
        File batFile = new File(batPath);
        boolean batFileExist = batFile.exists();
        System.out.println("batFileExist:" + batFileExist);
        if (batFileExist) {
            callCmd(batPath);
        }
    }

    private static void  callCmd(String locationCmd){
        StringBuilder sb = new StringBuilder();
        try {
            Process child = Runtime.getRuntime().exec(locationCmd);
            InputStream in = child.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in));
            String line;
            while((line=bufferedReader.readLine())!=null)
            {
                sb.append(line + "\n");
            }
            in.close();
            try {
                child.waitFor();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("sb:" + sb.toString());
            System.out.println("callCmd execute finished");
        } catch (IOException e) {
            System.out.println(e);
        }
    }*/
}
