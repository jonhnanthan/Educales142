package com.educa.robotium;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.ImageButton;

import com.educa.R;
import com.educa.activity.AnswerColorMatchExercise;
import com.educa.activity.AnswerCompleteExercise;
import com.educa.activity.AnswerMultipleChoiceExercise;
import com.educa.activity.ChooseMatchExerciseActivity;
import com.educa.activity.ChooseModelActivity;
import com.educa.activity.ColorMatchExerciseStep1Activity;
import com.educa.activity.ColorMatchExerciseStep2Activity;
import com.educa.activity.ColorMatchExerciseStep3Activity;
import com.educa.activity.ColorMatchExerciseStep4Activity;
import com.educa.activity.CompleteExerciseStep1Activity;
import com.educa.activity.CompleteExerciseStep2Activity;
import com.educa.activity.CompleteExerciseStep3Activity;
import com.educa.activity.MainActivity;
import com.educa.activity.MultipleChoiceExerciseStep1Activity;
import com.educa.activity.MultipleChoiceExerciseStep2Activity;
import com.educa.activity.MultipleChoiceExerciseStep3Activity;
import com.educa.activity.StudentHomeActivity;
import com.educa.activity.TeacherHomeActivity;
import com.robotium.solo.Solo;

public class TestAll extends ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;

	public TestAll() {
		super(MainActivity.class);
	}

	@Override
	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void test_A_CreateColorExercise() throws Exception {
		solo.assertCurrentActivity("Expected MainActivity", MainActivity.class); 
		
		solo.clickOnText(getActivity().getApplicationContext().getString(R.string.teacher));
		solo.waitForActivity(TeacherHomeActivity.class);
		solo.assertCurrentActivity("Expected TeacherHomeActivity", TeacherHomeActivity.class); 
		solo.clickOnActionBarItem(R.id.new_exercise);

		solo.waitForActivity(ChooseModelActivity.class);
		solo.assertCurrentActivity("Expected ChooseModelActivity", ChooseModelActivity.class);
		final ImageButton imageButton1 = (ImageButton) solo.getView(R.id.bt_match);
		solo.clickOnView(imageButton1);
		solo.waitForView(imageButton1);

		solo.waitForActivity(ChooseMatchExerciseActivity.class);
		solo.assertCurrentActivity("Expected ChooseMatchExerciseActivity", ChooseMatchExerciseActivity.class); 
		final ImageButton imageButton2 = (ImageButton) solo.getView(R.id.bt_color_match);
		solo.clickOnView(imageButton2);
		solo.waitForView(imageButton2);

		solo.waitForActivity(ColorMatchExerciseStep1Activity.class);
		solo.assertCurrentActivity("Expected ColorMatchExerciseStep1Activity", ColorMatchExerciseStep1Activity.class); 

		//Pick the first color
		solo.clickInList(0);
		
		//Next step
		final ImageButton imageButton3 = (ImageButton) solo.getView(R.id.bt_next_step);
		solo.clickOnView(imageButton3);
		solo.waitForView(imageButton3);
		
		solo.waitForActivity(ColorMatchExerciseStep2Activity.class);
		solo.assertCurrentActivity("Expected ColorMatchExerciseStep2Activity", ColorMatchExerciseStep2Activity.class); 

		final EditText et = (EditText) solo.getView(R.id.question_match);
		assertEquals("Pergunta", et.getHint());
		solo.enterText(et, "Que cor eh essa?");
		final EditText et1 = (EditText) solo.getView(R.id.answer1_match);
		assertEquals("Resposta1", et1.getHint());
		solo.enterText(et1, "Preta");
		final EditText et2 = (EditText) solo.getView(R.id.answer2_match);
		assertEquals("Resposta2", et2.getHint());
		solo.enterText(et2, "Cinza");
		final EditText et3 = (EditText) solo.getView(R.id.answer3_match);
		assertEquals("Resposta3", et3.getHint());
		solo.enterText(et3, "Marrom");
		final EditText et4 = (EditText) solo.getView(R.id.answer4_match);
		assertEquals("Resposta4", et4.getHint());
		solo.enterText(et4, "Amarela");
		
		//Next step
		final ImageButton imageButton4 = (ImageButton) solo.getView(R.id.bt_ok_match);
		solo.clickOnView(imageButton4);
		solo.waitForView(imageButton4);
		
		solo.waitForActivity(ColorMatchExerciseStep3Activity.class);
		solo.assertCurrentActivity("Expected ColorMatchExerciseStep3Activity", ColorMatchExerciseStep3Activity.class); 

		//Click on the right answer
		solo.clickOnRadioButton(2);
		
		//Next step
		final ImageButton imageButton5 = (ImageButton) solo.getView(R.id.confirm);
		solo.clickOnView(imageButton5);
		solo.waitForView(imageButton5);

		solo.waitForActivity(ColorMatchExerciseStep4Activity.class);
		solo.assertCurrentActivity("Expected ColorMatchExerciseStep4Activity", ColorMatchExerciseStep4Activity.class); 

		final EditText et5 = (EditText) solo.getView(R.id.et_name);
		assertEquals(solo.getString(R.string.exercise_name), et5.getHint());
		solo.enterText(et5, "Exercicio de cores");
		
		final ImageButton imageButton6 = (ImageButton) solo.getView(R.id.bt_save);
		solo.clickOnView(imageButton6);
		solo.waitForView(imageButton6);
		solo.waitForActivity(TeacherHomeActivity.class);
		solo.assertCurrentActivity("Expected TeacherHomeActivity", TeacherHomeActivity.class); 
	}
	
	public void test_B_CreateCompleteExercise() throws Exception {
		solo.assertCurrentActivity("Expected MainActivity", MainActivity.class); 
		
		solo.clickOnText(getActivity().getApplicationContext().getString(R.string.teacher));
		solo.waitForActivity(TeacherHomeActivity.class);
		solo.assertCurrentActivity("Expected TeacherHomeActivity", TeacherHomeActivity.class); 
		solo.clickOnActionBarItem(R.id.new_exercise);
		
		solo.waitForActivity(ChooseModelActivity.class);
		solo.assertCurrentActivity("Expected ChooseModelActivity", ChooseModelActivity.class);
		final ImageButton imageButton1 = (ImageButton) solo.getView(R.id.bt_complete);
		solo.clickOnView(imageButton1);
		solo.waitForView(imageButton1);

		solo.waitForActivity(CompleteExerciseStep1Activity.class);
		solo.assertCurrentActivity("Expected CompleteExerciseStep1Activity", CompleteExerciseStep1Activity.class); 

		final EditText et = (EditText) solo.getView(R.id.question);
		assertEquals("Pergunta / Dica", et.getHint());
		solo.enterText(et, "Lugar onde voce mora");
		final EditText et1 = (EditText) solo.getView(R.id.word);
		assertEquals("Palavra", et1.getHint());
		solo.enterText(et1, "casa");
		
		final ImageButton imageButton2 = (ImageButton) solo.getView(R.id.bt_next_step);
		solo.clickOnView(imageButton2);
		solo.waitForView(imageButton2);
		
		solo.waitForActivity(CompleteExerciseStep2Activity.class);
		solo.assertCurrentActivity("Expected CompleteExerciseStep2Activity", CompleteExerciseStep2Activity.class); 

		solo.clickOnCheckBox(2);
		
		final ImageButton imageButton3 = (ImageButton) solo.getView(R.id.confirm);
		solo.clickOnView(imageButton3);
		solo.waitForView(imageButton3);
		
		solo.waitForActivity(CompleteExerciseStep3Activity.class);
		solo.assertCurrentActivity("Expected CompleteExerciseStep3Activity", CompleteExerciseStep3Activity.class); 

		final EditText et2 = (EditText) solo.getView(R.id.et_name);
		assertEquals(solo.getString(R.string.exercise_name), et2.getHint());
		solo.enterText(et2, "Exercicio de completar");
		
		final ImageButton imageButton4 = (ImageButton) solo.getView(R.id.bt_save);
		solo.clickOnView(imageButton4);
		solo.waitForView(imageButton4);
		solo.waitForActivity(TeacherHomeActivity.class);
		solo.assertCurrentActivity("Expected TeacherHomeActivity", TeacherHomeActivity.class); 
	}
	
	public void test_C_CreateMultipleChoiceExercise() throws Exception {
		solo.assertCurrentActivity("Expected MainActivity", MainActivity.class); 
		
		solo.clickOnText(getActivity().getApplicationContext().getString(R.string.teacher));
		solo.waitForActivity(TeacherHomeActivity.class);
		solo.assertCurrentActivity("Expected TeacherHomeActivity", TeacherHomeActivity.class); 
		solo.clickOnActionBarItem(R.id.new_exercise);

		solo.waitForActivity(ChooseModelActivity.class);
		solo.assertCurrentActivity("Expected ChooseModelActivity", ChooseModelActivity.class);
		final ImageButton imageButton1 = (ImageButton) solo.getView(R.id.bt_multiplechoice);
		solo.clickOnView(imageButton1);
		solo.waitForView(imageButton1);

		solo.waitForActivity(MultipleChoiceExerciseStep1Activity.class);
		solo.assertCurrentActivity("Expected MultipleChoiceExerciseStep1Activity", MultipleChoiceExerciseStep1Activity.class); 
		
		final EditText et = (EditText) solo.getView(R.id.question_match);
		assertEquals("Pergunta", et.getHint());
		solo.enterText(et, "Qual o ultimo mes do ano?");
		final EditText et1 = (EditText) solo.getView(R.id.answer1_match);
		assertEquals("Resposta1", et1.getHint());
		solo.enterText(et1, "Janeiro");
		final EditText et2 = (EditText) solo.getView(R.id.answer2_match);
		assertEquals("Resposta2", et2.getHint());
		solo.enterText(et2, "Novembro");
		final EditText et3 = (EditText) solo.getView(R.id.answer3_match);
		assertEquals("Resposta3", et3.getHint());
		solo.enterText(et3, "Dezembro");
		final EditText et4 = (EditText) solo.getView(R.id.answer4_match);
		assertEquals("Resposta4", et4.getHint());
		solo.enterText(et4, "Outubro");

		final ImageButton imageButton2 = (ImageButton) solo.getView(R.id.bt_ok_match);
		solo.clickOnView(imageButton2);
		solo.waitForView(imageButton2);
		
		solo.waitForActivity(MultipleChoiceExerciseStep2Activity.class);
		solo.assertCurrentActivity("Expected MultipleChoiceExerciseStep2Activity", MultipleChoiceExerciseStep2Activity.class); 
	
		solo.clickOnRadioButton(2);
		
		final ImageButton imageButton3 = (ImageButton) solo.getView(R.id.confirm);
		solo.clickOnView(imageButton3);
		solo.waitForView(imageButton3);
		solo.waitForActivity(MultipleChoiceExerciseStep3Activity.class);
		solo.assertCurrentActivity("Expected MultipleChoiceExerciseStep3Activity", MultipleChoiceExerciseStep3Activity.class); 
	
		final EditText et5 = (EditText) solo.getView(R.id.et_name);
		assertEquals(solo.getString(R.string.exercise_name), et5.getHint());
		solo.enterText(et5, "Exercicio dos meses");
		
		final ImageButton imageButton4 = (ImageButton) solo.getView(R.id.bt_save);
		solo.clickOnView(imageButton4);
		solo.waitForView(imageButton4);
		
		solo.clickOnImage(2);
		solo.waitForActivity(TeacherHomeActivity.class);
		solo.assertCurrentActivity("Expected TeacherHomeActivity", TeacherHomeActivity.class); 
	}

	public void test_D_AnswerColorExercise() throws Exception {
		solo.assertCurrentActivity("Expected MainActivity", MainActivity.class); 
		
		solo.clickOnText(getActivity().getApplicationContext().getString(R.string.student));
		solo.waitForActivity(StudentHomeActivity.class);
		solo.assertCurrentActivity("Expected StudentHomeActivity", StudentHomeActivity.class);
		
		solo.clickOnText("Exercicio de cores");
		solo.waitForActivity(AnswerColorMatchExercise.class);
		solo.assertCurrentActivity("Expected AnswerColorMatchActivity", AnswerColorMatchExercise.class);
		
		solo.clickOnRadioButton(2);
		
		ImageButton imageButon = (ImageButton) solo.getView(R.id.bt_save);
		solo.clickOnView(imageButon);
		solo.waitForView(imageButon);
		
		solo.clickOnMenuItem(getActivity().getResources().getString(R.string.ok));
		solo.waitForActivity(StudentHomeActivity.class);
		solo.assertCurrentActivity("Expected StudentHomeActivity", StudentHomeActivity.class);
	
	}
	
	public void test_E_AnswerCompleteExercise() throws Exception {
		solo.assertCurrentActivity("Expected MainActivity", MainActivity.class); 
		
		solo.clickOnText(getActivity().getApplicationContext().getString(R.string.student));
		solo.waitForActivity(StudentHomeActivity.class);
		solo.assertCurrentActivity("Expected StudentHomeActivity", StudentHomeActivity.class);
		
		solo.clickOnText("Exercicio de completar");
		solo.waitForActivity(AnswerCompleteExercise.class);
		solo.assertCurrentActivity("Expected AnswerCompleteExercise", AnswerCompleteExercise.class);
		
		EditText et = (EditText) solo.getView(R.id.bt_letter3);
		solo.enterText(et, "S");
		
		ImageButton imageButton = (ImageButton) solo.getView(R.id.bt_save);
		solo.clickOnView(imageButton);
		solo.waitForView(imageButton);
		
		solo.clickOnText(getActivity().getResources().getString(R.string.ok));

		solo.waitForActivity(StudentHomeActivity.class);
		solo.assertCurrentActivity("Expected StudentHomeActivity", StudentHomeActivity.class);
	}
	
	public void test_F_AnswerMultipleChoiceExercise() throws Exception {
		solo.assertCurrentActivity("Expected MainActivity", MainActivity.class); 
		
		solo.clickOnText(getActivity().getApplicationContext().getString(R.string.student));
		solo.waitForActivity(StudentHomeActivity.class);
		solo.assertCurrentActivity("Expected StudentHomeActivity", StudentHomeActivity.class);
		
		solo.clickOnText("Exercicio dos meses");
		solo.waitForActivity(AnswerMultipleChoiceExercise.class);
		solo.assertCurrentActivity("Expected AnswerColorMatchActivity", AnswerMultipleChoiceExercise.class);
		
		solo.clickOnRadioButton(2);
		
		ImageButton imageButon = (ImageButton) solo.getView(R.id.bt_save);
		solo.clickOnView(imageButon);
		solo.waitForView(imageButon);
		
		solo.clickOnMenuItem(getActivity().getResources().getString(R.string.ok));
		solo.waitForActivity(StudentHomeActivity.class);
		solo.assertCurrentActivity("Expected StudentHomeActivity", StudentHomeActivity.class);

	}
	
//	public void test_G_EditMultipleChoiceExercise() throws Exception {
//		solo.clickOnText(getActivity().getApplicationContext().getString(R.string.teacher));
//		solo.assertCurrentActivity("Expected MainActivity", MainActivity.class); 
//
//		View view = solo.getView(R.id.bt_options);
//		solo.clickOnView(view);
//		
//		solo.clickOnText(getActivity().getApplicationContext().getResources().getString(R.string.edit));
//		solo.assertCurrentActivity("Expected EditMultipleChoiceExerciseActivity", EditMultipleChoiceExerciseActivity.class); 
//		
//		solo.enterText(0, "");
//		solo.enterText(0, "Qual o m�s dos dias das crian�as?");
//		
//		solo.enterText(1, "");
//		solo.enterText(1, "Mar�o");
//		
//		solo.enterText(2, "");
//		solo.enterText(2, "Agosto");
//		
//		solo.enterText(3, "");
//		solo.enterText(3, "Setembro");
//		
//		solo.enterText(4, "");
//		solo.enterText(4, "Outubro");
//		
//		solo.clickOnRadioButton(3);
//		solo.clickOnImage(2);
//
//		solo.waitForDialogToOpen();
//		solo.clickOnText(getActivity().getResources().getString(R.string.ok));
//		solo.waitForDialogToClose();
//		
//		solo.waitForActivity(TeacherHomeActivity.class);
//		solo.assertCurrentActivity("Expected TeacherHomeActivity", TeacherHomeActivity.class); 
//	}
//	
//	public void test_H_DeleteExercises() throws Exception {
//		solo.clickOnText(getActivity().getApplicationContext().getString(R.string.teacher));
//		solo.assertCurrentActivity("Expected MainActivity", MainActivity.class); 
//
//		View view = solo.getView(R.id.bt_options);
//		solo.clickOnView(view);
//		
//		solo.clickOnText(getActivity().getApplicationContext().getResources().getString(R.string.delete));
//		solo.waitForDialogToOpen();
//		solo.clickOnText(getActivity().getApplicationContext().getResources().getString(R.string.ok));
//		solo.waitForDialogToClose();
//		
//		solo.waitForActivity(TeacherHomeActivity.class);
//		solo.assertCurrentActivity("Expected TeacherHomeActivity", TeacherHomeActivity.class); 
//		
//		view = solo.getView(R.id.bt_options);
//		solo.clickOnView(view);
//		
//		solo.clickOnText(getActivity().getApplicationContext().getResources().getString(R.string.delete));
//		solo.waitForDialogToOpen();
//		solo.clickOnText(getActivity().getApplicationContext().getResources().getString(R.string.ok));
//		solo.waitForDialogToClose();
//		
//		solo.waitForActivity(TeacherHomeActivity.class);
//		solo.assertCurrentActivity("Expected TeacherHomeActivity", TeacherHomeActivity.class); 
//	}

	
	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}
}