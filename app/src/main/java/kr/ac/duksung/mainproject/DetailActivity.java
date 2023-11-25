package kr.ac.duksung.mainproject;



import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    TextView detaildate, emotiontext, detailcontent;
    ImageView detailemotion;
    Button detailbtn1, detailbtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        emotiontext = findViewById(R.id.emotiontext);
        detaildate = findViewById(R.id.detaildate);
        detailcontent = findViewById(R.id.detailcontent);
        detailemotion = findViewById(R.id.detailemotion); // 이미지뷰 초기화
        detailbtn1 = findViewById(R.id.detailbtn1);
        detailbtn2 = findViewById(R.id.detailbtn2);

        // WriteActivity에서 전달한 Intent를 받아옴
        Intent intent = getIntent();

        // WriteActivity에서 전달한 'content'와 'date'를 받아옵니다.
        String contentText = intent.getStringExtra("content");
        String dateText = intent.getStringExtra("date");

        // 'content'와 'date'를 각각의 TextView에 설정합니다.
        detailcontent.setText(contentText);
        detaildate.setText(dateText);

        // 'content' 내용이 "기쁨"이면 'happy_image', 그렇지 않으면 'sad_image'를 보여줍니다.
        if (contentText.contains("기쁨")) {
            detailemotion.setImageResource(R.drawable.ic_happy);
        } else if (contentText.contains("슬픔")) {
            detailemotion.setImageResource(R.drawable.ic_sad);
        } else if (contentText.contains("분노")) {
            detailemotion.setImageResource(R.drawable.ic_angry);
        } else if (contentText.contains("지루함")) {
            detailemotion.setImageResource(R.drawable.ic_bored);
        } else if (contentText.contains("사랑")) {
            detailemotion.setImageResource(R.drawable.ic_love);
        } else if (contentText.contains("불안")) {
            detailemotion.setImageResource(R.drawable.ic_anxiety);
        } else {
            // 기본 이미지 또는 다른 처리를 원하는 대로 설정할 수 있습니다.
            detailemotion.setImageResource(R.drawable.ic_happy);
        }

        emotiontext.setText("OOO님은 오늘 "+ contentText + "입니다");

    }
}