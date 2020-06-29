package com.example.hazza.ui.main.categorias;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;

import com.example.hazza.BR;
import com.example.hazza.R;
import com.example.hazza.ViewModelProviderFactory;
import com.example.hazza.databinding.FragmentCategoriasBinding;
import com.example.hazza.ui.base.BaseFragment;
import com.example.hazza.utils.AppConstants;
import java.util.List;
import javax.inject.Inject;

public class CategoriasFragment extends BaseFragment<FragmentCategoriasBinding,CategoriaViewModel>
            implements CategoriaNavigator,CategoariaAdapter.CategoriaAdapterListener{

    @Inject
    ViewModelProviderFactory factory;

    @Inject
    CategoariaAdapter categoariaAdapter;

    private CategoriaViewModel categoriaViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categoriaViewModel.setNavigator(this);
        categoariaAdapter.setmListener(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onRetryClick();
        setUp();
    }


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_categorias;
    }

    @Override
    public CategoriaViewModel getViewModel() {
        categoriaViewModel= new ViewModelProvider(this,factory).get(CategoriaViewModel.class);
        return categoriaViewModel;
    }

    @Override
    public void onItemClick(CategoriaDataItem item) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(AppConstants.ARTICLE, item);
        getNavController().navigate(R.id.action_articleFragment_to_articleDetailsFragment, bundle);
    }

    @Override
    public void handleError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(List<CategoriaDataItem> data) {
        categoariaAdapter.addItems(data);
    }

    @Override
    public void onRetryClick() {
        categoriaViewModel.getCategorias();
    }

    private void setUp() {
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
       // getViewDataBinding().rcyCategorias.setLayoutManager(new LinearLayoutManager(getActivity()));
        getViewDataBinding().rcyCategorias.setItemAnimator(new DefaultItemAnimator());
        getViewDataBinding().rcyCategorias.setAdapter(categoariaAdapter);
    }


}