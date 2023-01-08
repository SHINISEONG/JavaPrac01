import java.util.Scanner;
import java.util.Random;
class  Draw
{
	///field
	int numTeamPeople;
	int totalMember;
	int numTeam;
	String[] teamName = {"�赿��","�����","�輮��","�輺��","����","�迵��","������","�����","�ڰ���","�ڼ���","������","������","���翬","�ۿ���","�ۿ��","����","�ȹ�ȣ","����ȣ","������","�̵���","�̽���","������","������","������","��ö","������","����â","������","�ּ���"};
	int totalPeople = teamName.length;
	int[] leader;
	String[] leaderName;
	///constructor
	public Draw(){
	}
	public Draw(int numTeamPeople){
		this.numTeamPeople = numTeamPeople;
		this.numTeam = (int)(Math.ceil((double)totalPeople/numTeamPeople));
		this.totalMember = totalPeople-numTeam;
		this.leader = new int[numTeam];
		this.leaderName = new String[numTeam];
	}
	///method
	public void setLeader(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� ��ȣ�� �Է��� �ּ���.(������ �� "+numTeam+"�� �Դϴ�.)(�� ������� �Է����ּ���.)\n> ");
		for (int i=0; i<numTeam; i++)
		{
			this.leader[i]=scanner.nextInt();
			this.leaderName[i]=this.teamName[this.leader[i]-1];
			this.teamName[this.leader[i]-1]="_";
		}
	}
	
	public void blankSort(){
		String tmp;
		int blankCnt=0;
		for (int i=0; i<totalPeople; i++)
		{
			if (this.teamName[i] == "_")
			{
				for (int j=0; j<this.numTeam; j++)
				{
					if (this.teamName[totalPeople-j-1] == "_")
					{
						blankCnt++;
					} else {
						tmp = this.teamName[i];
						this.teamName[i]=this.teamName[totalPeople-j-1];
						this.teamName[totalPeople-j-1] = tmp;
						blankCnt++;
						break;
					}

				}
			}


		}
	}

	public void draw(){
//		this.blankSort();
		String tmp;
		Random rand = new Random();
		int randTmp;

		for (int i=0; i<10000; i++)
		{
			for(int j=0; j<totalPeople; j++){
				randTmp=rand.nextInt(totalPeople);
				tmp = this.teamName[j];
				this.teamName[j] = this.teamName[randTmp];
				this.teamName[randTmp] = tmp;
			}
		}
	}

	public void draw(int drawNum){
		String tmp;
		Random rand = new Random();
		int randTmp;
		for (int i=0; i<drawNum; i++)
		{
			for(int j=0; j<totalPeople; j++){
				randTmp=rand.nextInt(totalPeople);
				tmp = this.teamName[j];
				this.teamName[j] = this.teamName[randTmp];
				this.teamName[randTmp] = tmp;
			}
		}
	}

	public void print(){
		System.out.println("======================================================================================");
		System.out.println("\t\t\t\tNcloud 2�� �� ��\t\t\t\t");
		System.out.println("======================================================================================");
/*-----------------------------------------���ڰ� ��� �غ����� �����Ÿ�------------------------------------------
		for (int i=0;i<this.numTeam ; i+=2)
		{
			if(i!=(this.numTeam-1)){
				System.out.println("|\t\t"+(i+1)+"��\t\t|\t\t|"+(i+2)+"��\t\t|");
				System.out.println("-----------------------------------------");
				System.out.println("���� : " + this.leader[i] +"\t\t\t\t���� : "+ this.leader[i+1]);
				System.out.println("-----------------------------------------");
				for(int j=0; j<2; j++){
					if (j==0) {
						for(int k=0; k<i+3; k++){
							System.out.print(this.teamName[k+
						}
					}
				}
			}
		}
-----------------------------------------------------------------------------------------------------*/
		for(int i = 0; i<this.numTeam; i++){
			System.out.print("\t"+(i+1)+"��\t");
		}
		System.out.println("\n--------------------------------------------------------------------------------------");
		for(int i = 0; i<this.numTeam; i++){
			System.out.print("\t����\t");
		}
		System.out.println("");
		for(int i = 0; i<this.numTeam; i++){
			System.out.print("\t"+this.leaderName[i]+"\t");
		}
		System.out.println("\n--------------------------------------------------------------------------------------");
		for(int i=0; i<this.numTeamPeople-1; i++){
			for(int j=0; j<this.numTeam; j++){
				if ((i+(j*5))==((numTeamPeople-1)*numTeam))
				{
					break;
				}
				System.out.print("\t"+this.teamName[i+(j*5)]+"\t");
			}
			if (i==this.numTeamPeople-2)
			{
				System.out.println("\n--------------------------------------------------------------------------------------");
				break;
			}
			System.out.println("");
		}

	}
}// end of class



///AppClass
public class App {
	/// mainMethod
public static void main(String[] args){
	int numTeamPeople = 6;
	Draw draw = new Draw(numTeamPeople);
	draw.setLeader();
	draw.draw();
	draw.blankSort();
	draw.print();
 }// end of main
}// end of appclass






