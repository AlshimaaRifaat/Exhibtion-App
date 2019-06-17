package com.exhibtion.activity;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.widget.Toast;

import com.example.alshimaa.exhibtion.presenter.ExhibtionDiagramPresenter;
import com.example.alshimaa.exhibtion.view.ExhibtionDiagramView;
import com.example.exhibtion.model.ExhibtionDiagramData;
import com.exhibtion.Language;
import com.exhibtion.R;
import com.exhibtion.adapter.ExhibtionDiagramAdapter;

import java.util.List;

public class ExhibtionDiagramActivity extends AppCompatActivity implements ExhibtionDiagramView{
    RecyclerView recyclerViewDiagram;
   com.exhibtion.adapter.ExhibtionDiagramAdapter exhibtionDiagramAdapter;
    ExhibtionDiagramPresenter exhibtionDiagramPresenter;
    String FairId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dialog dialog=new Dialog( this );
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable( false );
        setContentView(R.layout.activity_exhibtion_diagram);
        init();
        FairId = getIntent().getStringExtra("fairId");
        //Toast.makeText(this, FairId, Toast.LENGTH_SHORT).show();
        ExhibtionDiagram();
    }

    private void init() {
        recyclerViewDiagram=findViewById(R.id.exhibtion_diagram_recycler);
    }

    private void ExhibtionDiagram() {
        exhibtionDiagramPresenter=new ExhibtionDiagramPresenter(getApplicationContext(),this);
        exhibtionDiagramPresenter.getExhibtionDiagramResult(FairId);
    }

    @Override
    public void showExhibtionDiagramList(List<ExhibtionDiagramData> exhibtionDiagramDataList) {
        exhibtionDiagramAdapter=new ExhibtionDiagramAdapter( getApplicationContext(),exhibtionDiagramDataList );
        recyclerViewDiagram.setLayoutManager( new LinearLayoutManager(getApplicationContext()));
        recyclerViewDiagram.setAdapter( exhibtionDiagramAdapter );

    }

    @Override
    public void showExhibtionDiagramError() {

    }
}
