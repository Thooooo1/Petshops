package nguyen.tho123.petshop.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import nguyen.tho123.petshop.Dao.NguoiDungDao;
import nguyen.tho123.petshop.Model.NguoiDung;
import nguyen.tho123.petshop.Model.SanPham;
import nguyen.tho123.petshop.R;
import nguyen.tho123.petshop.adapter.adapter_quanly_nap_tien;
import nguyen.tho123.petshop.databinding.FragmentFrgQuanLyNapTienBinding;
import nguyen.tho123.petshop.databinding.FragmentFrgTrangChuBinding;


public class frgQuanLyNapTien extends Fragment {
    View view;
    FragmentFrgQuanLyNapTienBinding binding;
    ArrayList<NguoiDung> list;
    adapter_quanly_nap_tien adapter;
        NguoiDungDao dao;
    public frgQuanLyNapTien() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFrgQuanLyNapTienBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        view = binding.getRoot();
        dao=new NguoiDungDao(getContext());
        list=dao.getAllNguoiDung();
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        binding.rcvNapTien.setLayoutManager(layoutManager);
        adapter=new adapter_quanly_nap_tien(list,getContext());
        binding.rcvNapTien.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }
}