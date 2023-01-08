import java.util.Scanner;
import java.util.Random;
class  Draw
{
	///field
	int numTeamPeople;
	int totalMember;
	int numTeam;
	String[] teamName = {"김동욱","김미형","김석찬","김성구","김양수","김영훈","김태희","김희수","박강락","박성원","박은진","박주현","소재연","송영준","송용범","신희성","안민호","유정호","윤예슬","이동욱","이승현","이재익","이현석","임유성","임철","전유빈","전지창","정종현","최성락"};
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
		System.out.print("조장 번호를 입력해 주세요.(조장은 총 "+numTeam+"명 입니다.)(조 순서대로 입력해주세요.)\n> ");
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
		System.out.println("\t\t\t\tNcloud 2기 조 편성\t\t\t\t");
		System.out.println("======================================================================================");
/*-----------------------------------------예쁘게 출력 해보려던 뻘짓거리------------------------------------------
		for (int i=0;i<this.numTeam ; i+=2)
		{
			if(i!=(this.numTeam-1)){
				System.out.println("|\t\t"+(i+1)+"조\t\t|\t\t|"+(i+2)+"조\t\t|");
				System.out.println("-----------------------------------------");
				System.out.println("조장 : " + this.leader[i] +"\t\t\t\t조장 : "+ this.leader[i+1]);
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
			System.out.print("\t"+(i+1)+"조\t");
		}
		System.out.println("\n--------------------------------------------------------------------------------------");
		for(int i = 0; i<this.numTeam; i++){
			System.out.print("\t조장\t");
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






