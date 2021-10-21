

import Tests.Node;
import Tests.Part;
import Tests.PartType;
import Tests.Work;

import java.math.BigInteger;
import java.util.ArrayList;
 /*коментарий от руководителя :
    Я пытаюсь тебе намекнуть что тебе нужен не массив а сущность "ветка". Передавая ее в функцию форк я получу подветку этой ветки.
    Внутреннее устройство ветки на твое усмотрение.
     */

//как хранить и получать "ветки"?  И как отмечать верхнюю и нижнюю метрики например?


/*На вход  податся ветка(возможно это первоначальная перестановка- уровень 0) и  на выходе получаю подветку уровня тогоже уровня
 или на уровень ниже, если на текущем уровне подветки кончились. Сущность "ветка" внутри это список с одним или двумя
  указателями для удобства ветвления. */
public class Main  {
    public static void main(String[] args) {
        //тестовый код чтобы показать перемещение указателей и перестановки
        //перестановка 312465
        Node test=new Node(312465);
        System.out.println("indicatorOne-  "+test.indicatorOne+"   indicatorTwo-"+test.indicatorTwo);
        System.out.println("oldnode--->"+test.arrayList);
        System.out.println(test);
        System.out.println("-----------------------");

        Node newnode= fork(test);
        System.out.println("indicatorOne-  "+newnode.indicatorOne+"   indicatorTwo-"+newnode.indicatorTwo);
        System.out.println("newnode--->"+ newnode.arrayList);
        System.out.println(newnode);

        Node newnode1= fork(newnode);
        System.out.println("indicatorOne-  "+newnode1.indicatorOne+"   indicatorTwo-"+newnode1.indicatorTwo);
        System.out.println("newnode1--->"+newnode1.arrayList);
        System.out.println(newnode1);

        Node newnode2= fork(newnode1);
        System.out.println("indicatorOne-  "+newnode2.indicatorOne+"   indicatorTwo-"+newnode2.indicatorTwo);
        System.out.println("newnode2--->"+newnode1.arrayList);
        System.out.println(newnode2);

        Node newnode3= fork(newnode2);
        System.out.println("indicatorOne-  "+newnode3.indicatorOne+"   indicatorTwo-"+newnode3.indicatorTwo);
        System.out.println("newnode4--->"+newnode3.arrayList);
        System.out.println(newnode3);
        System.out.println("-------------");

        Node newnode4= fork(newnode3);
        System.out.println("indicatorOne-  "+newnode4.indicatorOne+"   indicatorTwo-"+newnode4.indicatorTwo);
        System.out.println("newnode4--->"+newnode4.arrayList);
        System.out.println(newnode4);

        Node newnode5= fork(newnode4);
        System.out.println("indicatorOne-  "+newnode5.indicatorOne+"   indicatorTwo-"+newnode5.indicatorTwo);
        System.out.println("newnode5--->"+newnode5.arrayList);
        System.out.println(newnode5);


    }



        static Node fork(Node i){

            Node newNode=new Node(i.perestanivka,i.indicatorOne,i.indicatorTwo,i.arrayList);
            if (newNode.indicatorTwo==newNode.arrayList.size()-1){
                newNode.indicatorOne++;
                newNode.indicatorTwo=newNode.indicatorOne+1;
            }

            if (newNode.indicatorOne>=newNode.arrayList.size()-2){
                return newNode;
            }

            int indicatorOne=newNode.indicatorOne;
            int indicatorTwo=++newNode.indicatorTwo;

            int temp=newNode.arrayList.get(indicatorTwo);
            newNode.arrayList.remove((Object)temp);
            newNode.arrayList.add(indicatorOne+1,temp);

            return newNode;
    }








    static Node metrik(Node i){
        BigInteger integer = BigInteger.valueOf(0);

        Work work1=new Work(1,14);
        Work work2=new Work(2,5);
        Work work3=new Work(3,7);

        PartType partType1=new PartType(1);
        partType1.workflow=new ArrayList<Work>();
        partType1.workflow.add(work1);
        partType1.workflow.add(work2);


        PartType partType2=new PartType(2);
        partType2.workflow=new ArrayList<Work>();
        partType2.workflow.add(work2);


        PartType partType3=new PartType(3);
        partType3.workflow=new ArrayList<Work>();
        partType3.workflow.add(work3);
        partType3.workflow.add(work2);


        PartType partType4=new PartType(4);

        partType4.workflow=new ArrayList<Work>();
        partType4.workflow.add(work2);
        partType4.workflow.add(work3);
        partType4.workflow.add(work1);





        Part part1=new Part(1,partType1);
        Part part2=new Part(2,partType1);
        Part part3=new Part(3,partType2);
        Part part4=new Part(4,partType3);
        Part part5=new Part(5,partType4);
        Part part6=new Part(6,partType2);
        Part part7=new Part(7,partType3);

//2 создаю списки по количеству линий(в данном случае их 3) Линия находится внутри объекта работа
//закидываю детали которые должны выполняться на какой то линии по очереди



 //3найти линию загруженную Частями с минимальным временем работы( вот мы нагрузили части, теперь нужно найти которая быстрее всего отработает)
     //завести счетчик по отработке линии в данном случае мы знаем что 3 детали, а одну деталь линия обрабатывает 14 минут
        ArrayList<Part>arrayList1=new ArrayList();
        arrayList1.add(part1);
        arrayList1.add(part2);
        arrayList1.add(part4);
        int count1=arrayList1.size()*work1.getTime();
        System.out.println(count1);

        ArrayList<Part>arrayList2=new ArrayList();
        arrayList2.add(part1);
        arrayList2.add(part2);
        arrayList2.add(part3);
        arrayList2.add(part4);
        arrayList2.add(part5);
        arrayList2.add(part6);
        arrayList2.add(part7);
        int count2=arrayList2.size()*work2.getTime();
        System.out.println(count2);

        ArrayList<Part>arrayList3=new ArrayList();
        arrayList3.add(part4);
        arrayList3.add(part5);
        arrayList3.add(part7);
        int count3=arrayList3.size()*work3.getTime();
        System.out.println(count3);

//сравниваю счетчикики, сравнил и знаю что  3счетчик быстрее всего отработает
//4.убираю с линии 2 все детали
        arrayList2.clear();
        integer= BigInteger.valueOf(count2);


return i;
    }

}