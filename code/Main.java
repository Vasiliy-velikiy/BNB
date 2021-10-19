package code;

import java.util.ArrayList;

public class Main  {
    public static void main(String[] args) {
        //тестовый код чтобы показать перемещение указателей и перестановки
//перестановка 312465
code.Node test=new code.Node(312465);
        System.out.println(test.arrayList);
        System.out.println("mark1-  "+test.mark1+"   mark2-"+test.mark2);
        System.out.println("-----------------------");

        fork(test);
        System.out.println("mark1-  "+test.mark1+"   mark2-"+test.mark2);
       System.out.println(test.arrayList);

        fork(test);
        System.out.println("mark1-  "+test.mark1+"   mark2-"+test.mark2);
        System.out.println(test.arrayList);

        fork(test);
        System.out.println("mark1-  "+test.mark1+"   mark2-"+test.mark2);
        System.out.println(test.arrayList);

        fork(test);
        System.out.println("mark1-  "+test.mark1+"   mark2-"+test.mark2);
        System.out.println(test.arrayList);
        System.out.println("------------");

        //2 маркер прошел по списку до конца- получается переключение , 1 маркер перемещается на индекс +1, второй ставиться рядом с ним
        System.out.println("смена 1го маркера на индекс 1");
        fork(test);
        System.out.println("mark1-  "+test.mark1+"   mark2-"+test.mark2);
        System.out.println(test.arrayList);

        fork(test);
        System.out.println("mark1-  "+test.mark1+"   mark2-"+test.mark2);
        System.out.println(test.arrayList);

        fork(test);
        System.out.println("mark1-  "+test.mark1+"   mark2-"+test.mark2);
        System.out.println(test.arrayList);


        //смена 1го маркера
        System.out.println("опять смена 1го маркера на индекс 2");
        fork(test);
        System.out.println("mark1-  "+test.mark1+"   mark2-"+test.mark2);
        System.out.println(test.arrayList);


        fork(test);
        System.out.println("mark1-  "+test.mark1+"   mark2-"+test.mark2);
        System.out.println(test.arrayList);

        System.out.println("опять смена 1го маркера на индекс 3");
        fork(test);
        System.out.println("mark1-  "+test.mark1+"   mark2-"+test.mark2);
        System.out.println(test.arrayList);
        System.out.println("--------------");

        System.out.println("опять смена 1го маркера на индекс 4 но уже перестановки все пройдены");
        fork(test);
        System.out.println("mark1-  "+test.mark1+"   mark2-"+test.mark2);
        System.out.println(test.arrayList);


        System.out.println("опять смена 1го маркера на индекс 5 но уже перестановки все пройдены");
        fork(test);
        System.out.println("mark1-  "+test.mark1+"   mark2-"+test.mark2);
        System.out.println(test.arrayList);

        System.out.println("опять смена 1го маркера на индекс 6 но уже перестановки все пройдены");
        fork(test);
        System.out.println("mark1-  "+test.mark1+"   mark2-"+test.mark2);
        System.out.println(test.arrayList);

    }


    /*коментарий от руководителя :
    Я пытаюсь тебе намекнуть что тебе нужен не массив а сущность "ветка". Передавая ее в функцию форк я получу подветку этой ветки.
    Внутреннее устройство ветки на твое усмотрение.
     */

    //как хранить и получать "ветки"?  И как отмечать верхнюю и нижнюю метрики например?


/*На вход  податся ветка(возможно это первоначальная перестановка- уровень 0) и  на выходе получаю подветку уровня тогоже уровня
 или на уровень ниже, если на текущем уровне подветки кончились. Сущность "ветка" внутри это список с одним или двумя
  указателями для удобства ветвления. */
        static code.Node fork(code.Node i){

    code.Node node2=i;
            if (i.mark2==i.arrayList.size()-1){
                i.mark1++;
                i.mark2=i.mark1+1;
            }

            if (i.mark1>=i.arrayList.size()-2){
              return i;
            }

            int mark1=i.mark1;
           int mark2=++i.mark2;




        int temp=i.arrayList.get(mark2);
            i.arrayList.remove((Object)temp);
            i.arrayList.add(mark1+1,temp);





return i;


    }

}