package com.example.hw_3_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class FourthFragment extends Fragment {
    TextView name;
    TextView surname;
    TextView age;
    TextView sex;
    TextView school;
    TextView work;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getInit();
        getBundle();
    }

    private void getInit() {
        name = requireActivity().findViewById(R.id.finalName);
        surname = requireActivity().findViewById(R.id.finalSurname);
        age = requireActivity().findViewById(R.id.finalAge);
        sex = requireActivity().findViewById(R.id.finalSex);
        school = requireActivity().findViewById(R.id.finalSchool);
        work = requireActivity().findViewById(R.id.finalWork);
    }

    private void getBundle() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String names = bundle.getString("name");
            String surnames = bundle.getString("surname");
            String ages = bundle.getString("age");
            String sexs = bundle.getString("sex");
            String schools = bundle.getString("school");
            String works = bundle.getString("work");
            name.setText("Имя: " + names);
            surname.setText("Фамилия: " + surnames);
            age.setText("Возраст: " + ages);
            sex.setText("Пол: " + sexs);
            school.setText("Место учебы: " + schools);
            work.setText("Место работы: " + works);
        } else {
            Toast.makeText(getActivity(), "ВЫ НЕ ВВЕЛИ ВСЕ ДАННЫЕ", Toast.LENGTH_LONG).show();
        }
    }
}