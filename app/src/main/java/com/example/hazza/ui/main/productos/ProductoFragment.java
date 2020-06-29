package com.example.hazza.ui.main.productos;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.hazza.BR;
import com.example.hazza.R;
import com.example.hazza.ViewModelProviderFactory;
import com.example.hazza.databinding.FragmentProductoBinding;
import com.example.hazza.ui.base.BaseFragment;
import com.example.hazza.ui.main.categorias.CategoriaDataItem;
import com.example.hazza.utils.AppConstants;

import java.util.List;
import javax.inject.Inject;


public class ProductoFragment extends BaseFragment<FragmentProductoBinding,ProductoViewModel>
        implements ProductoNavigator,ProductoAdapter.ProductoAdapterListener{

    @Inject
    ViewModelProviderFactory factory;

    @Inject
    ProductoAdapter productoAdapter;

    private ProductoViewModel productoViewModel;
    private CategoriaDataItem categoriaDataItem;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productoViewModel.setNavigator(this);
        productoAdapter.setmListener(this);
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
        return R.layout.fragment_producto;
    }

    @Override
    public ProductoViewModel getViewModel() {
        productoViewModel= new ViewModelProvider(this,factory).get(ProductoViewModel.class);
        return productoViewModel;
    }

    @Override
    public void onItemClick(ProductoDataItem item) {
        //  Bundle bundle = new Bundle();
        //bundle.putParcelable(AppConstants.ARTICLE, item);
        //getNavController().navigate(R.id.action_articleFragment_to_articleDetailsFragment, bundle);
    }

    @Override
    public void onRetryClick() {
        if (getArguments() != null) {
            categoriaDataItem = getArguments().getParcelable(AppConstants.ARTICLE);
            if (categoriaDataItem != null) {
                productoViewModel.getProductos(categoriaDataItem.getIdCategoria());
            }
        }
    }

    @Override
    public void handleError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(List<ProductoDataItem> data) {
        productoAdapter.addItems(data);
    }
    private void setUp() {
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        StaggeredGridLayoutManager _sGridLayoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        getViewDataBinding().rcyProductos.setLayoutManager(_sGridLayoutManager);
        getViewDataBinding().rcyProductos.setItemAnimator(new DefaultItemAnimator());
        getViewDataBinding().rcyProductos.setAdapter(productoAdapter);
    }
}