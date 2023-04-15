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

public class FirstFragment extends Fragment {
    EditText editText;
    EditText editTextTwo;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        onClick();
    }

    private void initViews() {
        editText = requireActivity().findViewById(R.id.name);
        editTextTwo = requireActivity().findViewById(R.id.surname);
        button = requireActivity().findViewById(R.id.buttonOne);
    }

    private void onClick() {
        button.setOnClickListener(view -> {
            if (!editText.getText().toString().isEmpty() && !editTextTwo.getText().toString().isEmpty()) {
                dataSend();
            } else {
                Toast.makeText(getActivity(), "Введите ваше имя и фамилию", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void dataSend() {
        String name = editText.getText().toString(),surname = editTextTwo.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("surname", surname);
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_view, secondFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}