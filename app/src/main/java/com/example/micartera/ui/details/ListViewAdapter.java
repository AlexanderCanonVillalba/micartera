package com.example.micartera.ui.details;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.micartera.R;
import com.example.micartera.domain.entity.FinancialAdjustment;

import java.util.List;

public class ListViewAdapter  extends ArrayAdapter<FinancialAdjustment> {

    private Context context;

    public ListViewAdapter(Context context, List<FinancialAdjustment> objects){
        super(context, 0, objects);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener inflater.
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // ¿Existe el view actual?
        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.list_item_lead,
                    parent,
                    false);
        }

        // Referencias UI.
        ImageView avatar = (ImageView) convertView.findViewById(R.id.iv_avatar);
        TextView category = (TextView) convertView.findViewById(R.id.tv_category);
        TextView description = (TextView) convertView.findViewById(R.id.tv_description);
        TextView date = (TextView) convertView.findViewById(R.id.tv_date);
        TextView value = (TextView) convertView.findViewById(R.id.txt_value);

        // Lead actual.
        FinancialAdjustment lead = getItem(position);

        // Setup.
        Glide.with(this.context).load(R.drawable.home).into(avatar);
        category.setText(lead.getCategory());
        description.setText(lead.getDescription());
        date.setText(lead.getDate().toString());
        value.setText(String.valueOf(lead.getValue()));

        return convertView;
    }
}
