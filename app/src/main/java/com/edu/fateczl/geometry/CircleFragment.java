package com.edu.fateczl.geometry;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.edu.fateczl.geometry.controller.IGeometryController;
import com.edu.fateczl.geometry.model.Circle;
import com.edu.fateczl.geometry.model.Rectangle;

/**
 * @author Adriano M Sanchez
 */
public class CircleFragment extends Fragment {

    private View view;
    private EditText etRadiusCircle;
    private TextView tvResultCircle;
    private Button btAreaCircle;
    private Button btPerimeterCircle;
    private IGeometryController<Circle> controller;

    public CircleFragment(IGeometryController<Circle> controller) {
        this.controller = controller;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_circle, container, false);
        etRadiusCircle = view.findViewById(R.id.etRadiusCircle);
        tvResultCircle = view.findViewById(R.id.tvResultCircle);
        btAreaCircle = view.findViewById(R.id.btAreaCircle);
        btAreaCircle.setOnClickListener(b -> calculateArea());
        btPerimeterCircle = view.findViewById(R.id.btPerimeterCircle);
        btPerimeterCircle.setOnClickListener( b -> calculatePerimeter());
        return view;
    }

    @SuppressLint("DefaultLocale")
    private void calculateArea(){
        try {
            Circle circle = new Circle();
            circle.setRadius(Float.parseFloat(etRadiusCircle.getText().toString()));
            tvResultCircle.setText(String.format("%s: %.2f", getString(R.string.bt_area), controller.getArea(circle)));
            etRadiusCircle.getText().clear();
        } catch (NumberFormatException e) {
            new AlertDialog.Builder(view.getContext()).setTitle(getString(R.string.error_alert_title)).setMessage(getString(R.string.invalid_input_message)).show();
        }
    }

    @SuppressLint("DefaultLocale")
    private void calculatePerimeter(){
        try {
            Circle circle = new Circle();
            circle.setRadius(Float.parseFloat(etRadiusCircle.getText().toString()));
            tvResultCircle.setText(String.format("%s: %.2f", getString(R.string.bt_perimeter), controller.getPerimeter(circle)));
            etRadiusCircle.getText().clear();
        } catch (NumberFormatException e) {
            new AlertDialog.Builder(view.getContext()).setTitle(getString(R.string.error_alert_title)).setMessage(getString(R.string.invalid_input_message)).show();
        }
    }
}