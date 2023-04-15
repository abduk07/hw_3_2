package com.example.hw_3_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ThirdFragment extends Fragment {
    EditText editText;
    EditText editTextTwo;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        onClick();
    }

    private void initViews() {
        editText = requireActivity().findViewById(R.id.school);
        editTextTwo = requireActivity().findViewById(R.id.work);
        button = requireActivity().findViewById(R.id.buttonThree);
    }

    private void onClick() {
        button.setOnClickListener(view -> {
            if (!editText.getText().toString().isEmpty() && !editTextTwo.getText().toString().isEmpty()) {
                dataSend();
            } else {
                Toast.makeText(getActivity(), "Введите ваше место учебы и место работы", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void dataSend() {
        Bundle bundle = getArguments();
        String school = editText.getText().toString(), work = editTextTwo.getText().toString();
        bundle.putString("school", school);
        bundle.putString("work", work);
        FourthFragment fourthFragment = new FourthFragment();
        fourthFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_view, fourthFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
