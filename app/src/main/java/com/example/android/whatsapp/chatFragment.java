package com.example.android.whatsapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

    public class chatFragment extends Fragment {
        ListView listview;
        String[] values = new String[] { "Nimish Khurana",
                "Shubh",
                "Anjali",
                "Deepak",
                "Isha",
                "Nikhil Garg","Prateek","Raghav","Urvi","Pragya"
        };
        String[] chatDescription = new String[] { "Hey There! Are you using whatsapp?",
                "Kya hal h bhai",
                "How is the scholarship going on?",
                "Where are you bro?",
                "M coming home sis",
                "Photo","Ksa h bhai","Uh tell?","Uh r so cute","Hye"
        };

        String[] chatDates = new String[] { "06:55",
                "YESTERDAY",
                "05/04/2018",
                "03/04/2018",
                "27/03/2018",
                "26/03/2018","25/03/2018","25/03/2018","25/03/2018","24/03/2018"
        };

        public chatFragment() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View rootView = inflater.inflate(R.layout.chat_fragment, container, false);
            listview = rootView.findViewById(R.id.chat_list);
            final ArrayList<String> chatNameList = new ArrayList<String>();
            for (int i = 0; i < values.length; ++i) {
                chatNameList.add(values[i]);
            }
            final ArrayList<String> chatDescriptionList = new ArrayList<String>();
            for (int i = 0; i < values.length; ++i) {
                chatDescriptionList.add(chatDescription[i]);
            }
            final ArrayList<String> chatDatesList = new ArrayList<String>();
            for (int i = 0; i < values.length; ++i) {
                chatDatesList.add(chatDates[i]);
            }
            final CustomChatAdapter adapter = new CustomChatAdapter(getActivity(), R.layout.sample_chat, chatNameList,chatDescriptionList,chatDatesList);
            listview.setAdapter(adapter);
            return rootView;
        }

    }

