
/*!
 * @file Ev3MotorSample.java
 * @brief モータ制御サンプルプログラム
 *
 * 参考ページ：https://qiita.com/murotani/items/2a98164f9b3819f8ee64
 * 
 */

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;
import lejos.hardware.BrickFinder;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.TextLCD;

/*!
 * @class Ev3MotorSample
 * @brief モータの動作テストを行うクラス
 */
public class Ev3MotorSample {
    /* ! 動作テストを実行する関数 */
    public void execSample() {
	// 必要インスタンス生成
	RegulatedMotor motor = new EV3LargeRegulatedMotor(MotorPort.B);
	EV3 ev3 = (EV3) BrickFinder.getLocal();
	TextLCD lcd = ev3.getTextLCD();

	// 初期画面表示
	lcd.drawString("MotorSample", 1, 0);

	while (true) {
	    // 速度10で前進
	    lcdShowAndForward(lcd, motor, 10);
	    Delay.msDelay(2000);

	    // 速度MAX/2で前進
	    lcdShowAndForward(lcd, motor, (int) (motor.getMaxSpeed() / 2));
	    Delay.msDelay(2000);

	    // 速度MAXで前進
	    lcdShowAndForward(lcd, motor, (int) motor.getMaxSpeed());
	    Delay.msDelay(2000);

	    // 速度10で後退
	    lcdShowAndBackward(lcd, motor, 10);
	    Delay.msDelay(2000);

	    // 速度MAX/2で後退
	    lcdShowAndBackward(lcd, motor, (int) (motor.getMaxSpeed() / 2));
	    Delay.msDelay(2000);

	    // 速度MAXで後退
	    lcdShowAndBackward(lcd, motor, (int) motor.getMaxSpeed());
	    Delay.msDelay(2000);
	}
    }

    /* ! LCDに情報を表示し、前進する関数 */
    private static void lcdShowAndForward(TextLCD lcd, RegulatedMotor motor, int speed) {
	String lcdTemplate = "Speed = ";
	// LCD表示
	lcd.drawString("Mode = Forward", 1, 1);
	lcd.drawString(lcdTemplate + speed, 1, 2);
	// スピード設定
	motor.setSpeed(speed);
	// 前進
	motor.forward();
    }

    /* ! LCDに情報を表示し、後退する関数 */
    private static void lcdShowAndBackward(TextLCD lcd, RegulatedMotor motor, int speed) {
	String lcdTemplate = "Speed = ";
	// LCD表示
	lcd.drawString("Mode = Backward", 1, 1);
	lcd.drawString(lcdTemplate + speed, 1, 2);
	// スピード設定
	motor.setSpeed(speed);
	// 前進
	motor.backward();
    }
}