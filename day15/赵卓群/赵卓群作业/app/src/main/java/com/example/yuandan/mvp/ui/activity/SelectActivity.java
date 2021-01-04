package com.example.yuandan.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yuandan.App;
import com.example.yuandan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectActivity extends AppCompatActivity {

    @BindView(R.id.tv_A)
    TextView tvA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        ButterKnife.bind(this);

        String data = App.getString("data", "1");

        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.tv_A)
    public void onViewClicked() {
        startActivity(new Intent(SelectActivity.this,MainActivity.class));
    }
}