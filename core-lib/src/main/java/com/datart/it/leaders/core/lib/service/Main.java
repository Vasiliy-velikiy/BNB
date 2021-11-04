package com.datart.it.leaders.core.lib.service;

import com.datart.it.leaders.core.lib.model.parts.*;

import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        int minT = 0;
        Work work1 = new Work(1, 14);
        Work work2 = new Work(2, 5);
        Work work3 = new Work(3, 7);

        PartType partType1 = new PartType(1);
        partType1.workflow = new ArrayList<Work>();
        partType1.workflow.add(work1);
        partType1.workflow.add(work2);


        PartType partType2 = new PartType(2);
        partType2.workflow = new ArrayList<Work>();
        partType2.workflow.add(work2);


        PartType partType3 = new PartType(3);
        partType3.workflow = new ArrayList<Work>();
        partType3.workflow.add(work3);
        partType3.workflow.add(work2);


        PartType partType4 = new PartType(4);
        partType4.workflow = new ArrayList<Work>();
        partType4.workflow.add(work2);
        partType4.workflow.add(work3);
        partType4.workflow.add(work1);

        Part part1 = new Part(1, partType1);
        Part part2 = new Part(2, partType1);
        Part part3 = new Part(3, partType2);
        Part part4 = new Part(4, partType3);
        Part part5 = new Part(5, partType4);
        Part part6 = new Part(6, partType2);
        Part part7 = new Part(7, partType3);

        ArrayList<Part> arrayList1 = new ArrayList();
        arrayList1.add(part1);
        arrayList1.add(part2);
        arrayList1.add(part4);

        int count1 = arrayList1.size() * work1.getTime();
        System.out.println(count1);

        ArrayList<Part> arrayList2 = new ArrayList();
        arrayList2.add(part1);
        arrayList2.add(part2);
        arrayList2.add(part3);
        arrayList2.add(part4);
        arrayList2.add(part5);
        arrayList2.add(part6);
        arrayList2.add(part7);
        int count2 = arrayList2.size() * work2.getTime();
        System.out.println(count2);

        ArrayList<Part> arrayList3 = new ArrayList();
        arrayList3.add(part4);
        arrayList3.add(part5);
        arrayList3.add(part7);
        int count3 = arrayList3.size() * work3.getTime();
        System.out.println(count3);

        System.out.println(minT);

        TransportLine transportLine = new TransportLine(1);
        transportLine.tsLine = new ArrayList<>();
        transportLine.tsLine.add(part4);
        transportLine.tsLine.add(part5);
        transportLine.tsLine.add(part7);


        // if pa

        /*int t1 = partType1.workflow.get(0).getTime() + partType1.workflow.get(1).getTime();
        int t2 = partType2.workflow.get(0).getTime();
        int t3 = partType3.workflow.get(0).getTime() + partType3.workflow.get(1).getTime();
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
         */


        //TransportLine transportLine = new TransportLine(1);
        //transportLine.tsLine = new ArrayList<>();
        //transportLine.tsLine.add(part1);

        /*ArrayList res_parts = new ArrayList();
        res_parts.add(arrayList1);
        res_parts.add(arrayList2);
        res_parts.add(arrayList3);
        */


    }
}

