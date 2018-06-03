package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import apps.sffa.com.ainaki.R;
import apps.sffa.com.ainaki.adapter.ProductCategoryAdapter;
import apps.sffa.com.ainaki.adapter.ProductMiniItemAdapter;
import apps.sffa.com.ainaki.model.Gender;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String GENDER = "GENDER";

    // TODO: Rename and change types of parameters
    private Gender mGender;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(Gender gender) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putInt(GENDER, gender.ordinal());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mGender = Gender.values()[getArguments().getInt(GENDER)];
        }
    }

    private RecyclerView recProductCategories;
    private FloatingActionButton fabGotoTop;
    private ScrollView scrView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        Toast.makeText(getContext(), "Gender "+mGender, Toast.LENGTH_SHORT).show();
        recProductCategories = (RecyclerView) view.findViewById(R.id.recProductCategories);
        fabGotoTop = (FloatingActionButton) view.findViewById(R.id.fabGotoTop);
        scrView = (ScrollView) view.findViewById(R.id.scrView);

        fabGotoTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                scrView.scrollTo(0, 0);
                scrView.fullScroll(scrView.FOCUS_UP);
            }
        });
        recProductCategories.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        ProductCategoryAdapter adapter = new ProductCategoryAdapter(getContext(), initProductItems());
        recProductCategories.setAdapter(adapter);
        recProductCategories.setNestedScrollingEnabled(false);
    }

    private ArrayList<String> initProductItems() {
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(Arrays.asList("Category #1", "Category #2", "Category #3", "Category #4", "Category #5", "Category #6"
                , "Category #7"
                , "Category #8"
                , "Category #9"
                , "Category #10"
                , "Category #11"
                , "Category #12"
                , "Category #13"
                , "Category #14"
                , "Category #15"
                , "Category #16"));
        return list;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // TODO Webservice here
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
