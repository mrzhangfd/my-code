package cn.sdu.test.tencent.test0906;

import java.util.*;


/**
 * @author icatzfd
 * ac
 * 通知传递
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        boolean[] teamNoticeFlag=new boolean[m];
        boolean[] memberNoticeFlag = new boolean[n + 1];
        HashMap<Integer, String> memberToTeam = new HashMap<>();
        ArrayList<ArrayList<Integer>> memberInTeam = new ArrayList<>();
        Stack<Integer> noticeingTeam = new Stack<>();
        for(int i=0;i<m;i++){
            int x=input.nextInt();
            ArrayList<Integer> tmp = new ArrayList<>();
            boolean noticeingThisTeam=false;
            for(int j=0;j<x;j++){
                int t=input.nextInt();
                if(t==0){
                    noticeingThisTeam=true;
                }
                String s = memberToTeam.get(t);
                if(s==null){
                    s=i+"-";
                }else{
                    s+=i+"-";
                }

                memberToTeam.put(t,s);
                tmp.add(t);
            }
            if(noticeingThisTeam)
                noticeingTeam.push(i);
            memberInTeam.add(tmp);


        }
        while (!noticeingTeam.empty()){

            Integer pop = noticeingTeam.pop();
            ArrayList<Integer> team = memberInTeam.get(pop);

            for(Integer member:team){
                String s = memberToTeam.get(member);
                if(s.length()<1)
                    continue;
                s = s.substring(0, s.length() - 1);
                String[] teamIndexs = s.split("-");
                for(String teamIndex:teamIndexs){
                    int t=Integer.parseInt(teamIndex);
                    if(teamNoticeFlag[t]){
                        continue;
                    }
                    ArrayList<Integer> members = memberInTeam.get(t);
                    for(Integer mem:members){
                        memberNoticeFlag[mem]=true;
                        String s1 = memberToTeam.get(mem);
                        if(s1.length()<1)
                            continue;
                        s1 = s1.substring(0, s1.length() - 1);
                        String[] teamIndexs2 = s1.split("-");
                        for(String teamIndex2:teamIndexs2){
                            int t2=Integer.parseInt(teamIndex2);
                            if(!teamNoticeFlag[t]){
                                noticeingTeam.push(t2);
                            }
                        }



                    }
                    teamNoticeFlag[t]=true;
                }



            }
        }

        int res=0;
        for(int i=0;i<=n;i++){
            if(memberNoticeFlag[i])
                res++;
        }
        System.out.println(res);
    }
}
