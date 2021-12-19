package com.app.cubegame;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.app.cubegame.adapter.GameAdapter;
import com.app.cubegame.implementer.RecyclerViewItemClickListener;
import com.app.cubegame.model.GameData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements RecyclerViewItemClickListener {

    private GameAdapter adapter;
    private RecyclerView rv;
    private final List<GameData> list = new ArrayList<>();
    private final List<Integer> listFinal = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        rv = findViewById(R.id.rv);

        if (getIntent() != null && getIntent().hasExtra("number")) {
            String spanNum = getIntent().getStringExtra("number");
            Log.e("Test", "Number: " + spanNum);

            for (int i = 0; i < Integer.parseInt(spanNum); i++) {
                list.add(new GameData(i, "W", false));
                listFinal.add(i);
            }

            Random rand = new Random();
            int num = rand.nextInt(list.size());
            list.get(num).setStrColor("B");
            listFinal.remove(num);

            adapter = new GameAdapter(list);
            rv.setAdapter(adapter);
            adapter.setOnRecyclerViewItemClickListener(this);
        }
    }

    // Function select an element base on index
    // and return an element
    public int getRandomElement(List<Integer> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    @Override
    public void onItemClick(int position, int flag, View view) {
        if (flag == 10) {
            if (list.get(position).getStrColor().equals("B")) {
                list.get(position).setStrColor("R");
//                listFinal.remove(position);
                int nextBlue = 0;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getStrColor().equals("B")) {
                        nextBlue = nextBlue + 1;
                    }
                }
                if (nextBlue == 0) {
                    if (listFinal.size() > 3) {
                        for (int i = 0; i < 3; i++) {
                            int pos = getRandomElement(listFinal);
                           // listFinal.remove(pos);
                            list.get(pos).setStrColor("B");
                        }
                    }
                }
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
//                    adapter.notifyItemChanged(position);
                }
            }
//            Log.e("Test", "Selected Number: " + position + " value: " + list.get(position).getStrColor());
        }
    }
}