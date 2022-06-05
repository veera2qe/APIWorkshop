package com.uitestcases;

import com.model.WebTable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListFilter {
    public static void main(String[] args) {
       List<WebTable> table=new ArrayList<>();

        table.add(new WebTable("HCL","hcl","101","301","10"));
        table.add(new WebTable("Apple","apl","101","301","10"));
        table.add(new WebTable("Amazon","amz","101","301","10"));
        table.add(new WebTable("Amaraja","amr","101","301","10"));
        table.add(new WebTable("Amul","aml","101","301","10"));
        table.add(new WebTable("BPL","bpl","101","301","10"));
        table.add(new WebTable("TCS","tcs","101","301","10"));
        table.add(new WebTable("CTS","cts","101","301","10"));

       List<WebTable> data=table.stream().filter(i->i.getCompany().startsWith("A")).collect(Collectors.toList());
       data.stream().forEach(System.out::println);
    }
}
