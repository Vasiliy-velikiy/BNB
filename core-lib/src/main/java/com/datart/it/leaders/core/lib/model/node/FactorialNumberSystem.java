package com.datart.it.leaders.core.lib.model.node;

public class FactorialNumberSystem {

   private char[]initialDownload= {'a','b','c','d','e'};  //исходная перестановка(загрузка элементов)

    public char[] getMass() {
        return initialDownload;
    }

    public void setMass(char[] mass) {
        this.initialDownload = mass;
    }

    public   char[] recoveryPermutations(String factorialNumber)  {
        char[]newDownload=new char[initialDownload.length];

        //разбиваю входящ цифры в факт сист исч на отдельные коэфициенты
        String string=String.valueOf(factorialNumber); //сделал так , потому что входной парметр в recoveryPermutations, был int

        if (string.length()>initialDownload.length||string.length()+1<initialDownload.length){  //если цифр факториал сист исч больше чам исходных элементов загрузки-выбросить исключение
          return null;

        }

        int[] coefficient=new int[string.length()];

        for (int i = 0; i <string.length() ; i++) {
            coefficient[i]=(Integer.parseInt(String.valueOf(string.charAt(i))));
        }

        for (int i = 0; i <initialDownload.length-1 ; i++) {
            int coeff=coefficient[i];
            char a=initialDownload[i];

            if(coeff>0){
                int count=0;
                for (int j =newDownload.length-1; j >=0 ; j--) {
                    if (newDownload[j]==0) {
                        count++;
                        if (count==coeff+1){
                            newDownload[j]=a;
                            count=0;
                        }
                    }
                }
            }

            else if (coeff==0){
                for (int j = newDownload.length-1; j >=0 ; j--) {
                    if(newDownload[j]==0){
                        newDownload[j]=a;
                        break;
                    }
                }
            }
        }

        //последний элемент засовываем на единственное свободное место
        for (int i = 0; i <newDownload.length ; i++) {
            if (newDownload[i]==0) newDownload[i]=initialDownload[initialDownload.length-1];
        }
        return newDownload;
    }
}
