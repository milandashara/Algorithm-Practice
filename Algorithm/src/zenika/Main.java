package zenika;

import java.util.*;

/**
 * Minimal Cost
 * Nuclear Rods Hackerrank problem
 */
public class Main {

    static int minimalCost(int n, List<String> pairs) {

        ArrayList<Set<Integer>> listOLists = new ArrayList<Set<Integer>>();

        //group pairs
        for(String s:pairs){
            String[] temp = s.split("\\s+");

            boolean isInGroup = false;
            int groupIndex = -1;
            int groupIndex2 = -1;
            boolean isInGroupMerge = false;
            for(String n3:temp){//size 2
                //System.out.println(n3);
                for(Set tempList:listOLists){
                    if(tempList.contains(Integer.parseInt(n3))){
                        if(isInGroup){
                            isInGroupMerge = true;
                            isInGroup = false;
                            groupIndex2 = listOLists.indexOf(tempList);
                            break;
                        }else{
                            isInGroup = true;
                            groupIndex = listOLists.indexOf(tempList);
                        }

                    }
                }
            }

            //merge index1 and index2
            if(isInGroupMerge){
                Set<Integer> nSet1 = listOLists.get(groupIndex);
                Set<Integer> nSet2 = listOLists.get(groupIndex2);

                nSet1.addAll(nSet2);
                listOLists.remove(groupIndex2);
            }

            else if(isInGroup){
                for(String n1:temp){//size 2
                    //System.out.println("group index :" + groupIndex);
                    Set<Integer> nSet = listOLists.get(groupIndex);
                    //listOLists.remove(nSet);
                    nSet.add(Integer.parseInt(n1));
                    //listOLists.add(nSet);

                    // for(Set<Integer> tempList:listOLists){
                    //     for(Integer tempInt:tempList){
                    //         System.out.print(tempInt);
                    //     }
                    //     System.out.println();
                    // }


                }
            }else{
                Set<Integer> newList = new HashSet();
                for(String n2:temp){//size 2
                    newList.add(Integer.parseInt(n2));
                }
                listOLists.add(newList);
            }
        }

        //add remaining element
//         for(int i=0;i<n;i++){

//             boolean isInGroup = false;
//             for(Set tempList:listOLists){
//                 if(tempList.contains(i+1)){
//                     isInGroup = true;
//                     break;
//                 }
//             }

//             if(!isInGroup){
//                 Set<Integer> newList = new HashSet();
//                 newList.add(i+1);
//                 listOLists.add(newList);

//             }

//         }

        //calculate minCost
        int minCost = 0;
        int calSize = 0;
        for(Set tempList:listOLists){

            int size = tempList.size();
            calSize = calSize + size;
            minCost = minCost + (int)Math.ceil(Math.sqrt(size));
            System.out.print(size+",");
            System.out.println((int)Math.ceil(Math.sqrt(size)));

        }

        return minCost + n - calSize;

    }
}
