/*!
 * @file Test.java
 * @brief テスト用プログラム
 * 
 */
//import lejos.hardware.port.SensorPort;
//import lejos.hardware.sensor.HiTechnicIRSeekerV2;

public class Test {

	public static void main(String[] args) {
		/*
		HiTechnicIRSeekerV2 seek = new HiTechnicIRSeekerV2(SensorPort.S1);	//インスタンス作成
	    float direction[] = new float[5];	//データ格納変数
	    seek.fetchSample(direction,0);		//データ取得メソッド
	    */
		Ev3MotorSample motorSample = new Ev3MotorSample();
		motorSample.execSample();
	}

}
