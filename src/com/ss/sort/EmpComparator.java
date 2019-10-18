package com.ss.sort;


import java.util.Comparator;
/*
 * 排序类
 */
public class EmpComparator implements Comparator<FaultResult>{
    public int compare(FaultResult faultResult1, FaultResult faultResult2) {  
          int cr = 0;  
          //先按年排升序
          int a = Integer.parseInt(faultResult2.getYear()) -Integer.parseInt( faultResult1.getYear());  
          if (a != 0) {  
              cr = (a < 0) ? 3 : -1;     // "<"升序     ">"降序
          } else {  
              //再按月排升序
              a =  Integer.parseInt(faultResult2.getMonth()) -  Integer.parseInt(faultResult1.getMonth());  
              if (a != 0) {  
                  cr = (a < 0) ? 2 : -2; // "<"升序     ">"降序
              }else{
            	//再按数量排升序
            	  a =  Integer.parseInt(faultResult2.getCount()) -  Integer.parseInt(faultResult1.getCount());  
            	  cr = (a < 0) ? 1 : -1; // "<"升序     ">"降序
              }
          }  
          return cr;  
    }
}

