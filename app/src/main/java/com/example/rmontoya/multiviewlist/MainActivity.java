package com.example.rmontoya.multiviewlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rmontoya.multiviewlist.adapter.HeterogeneousAdapter;
import com.example.rmontoya.multiviewlist.model.ContentRow;
import com.example.rmontoya.multiviewlist.model.Header;
import com.example.rmontoya.multiviewlist.model.typeinterface.ListElement;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.heterogeneos_list)
    RecyclerView heterogenousList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setList();
    }

    private void setList() {
        heterogenousList.setHasFixedSize(true);
        heterogenousList.setLayoutManager(new LinearLayoutManager(this));
        heterogenousList.setAdapter(new HeterogeneousAdapter(getListElements()));
    }

    public List<ListElement> getListElements() {
        List<ListElement> listElements = new ArrayList<>();
        listElements.add(new Header("First Header"));
        listElements.add(new ContentRow("First row"));
        listElements.add(new ContentRow("Second row"));
        listElements.add(new ContentRow("Third row"));
        listElements.add(new ContentRow("Four row"));
        listElements.add(new Header("Second Header"));
        listElements.add(new ContentRow("Fifth row"));
        listElements.add(new ContentRow("Sixth row"));
        listElements.add(new Header("Final Header"));
        return listElements;
    }

}
