package SerializationCheck;

import java.io.*;

public class ManageObject {

    public static void main(String[] args) {
        //파일 저장 경로
        String path = "C:"+File.separator+"Users"+File.separator+"urp시스템"+File.separator+"IdeaProjects"+File.separator+"objtest"+File.separator+"serial.obj";
        //경로에 저장될 객체
        SerialDto dto = new SerialDto("aaa","123","cool",11112222,true,2000L,"gold");

        ManageObject mo = new ManageObject();
        //mo.saveObj(path,dto);
        mo.loadObject(path);
    }

    public void saveObj(String path,SerialDto dto){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(dto);

            System.out.println("Object Write Success");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void loadObject(String path){
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            SerialDto dto = (SerialDto)ois.readObject();
            System.out.println(dto);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
