package com.example.fragmentweather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class InviernoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_season, container, false);

        RelativeLayout layout = view.findViewById(R.id.fragment_layout);
        TextView textView = view.findViewById(R.id.textView);

        layout.setBackgroundColor(getResources().getColor(R.color.gris));
        textView.setText("Estás en Invierno");

        return view;
    }
}
