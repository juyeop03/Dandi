package org.techtown.schooler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

@SuppressWarnings({"ALL", "SyntaxError"})
public class Adapter extends BaseAdapter {

    private ArrayList<DTO> listCustom = new ArrayList<>();

    // ListView에 보여질 Item 수
    @Override
    public int getCount() {
        return listCustom.size();
    }

    // 하나의 Item(ImageView 1, TextView 2)
    @Override
    public Object getItem(int position) {
        return listCustom.get(position);
    }

    // Item의 id : Item을 구별하기 위한 것으로 position 사용
    @Override
    public long getItemId(int position) {
        return position;
    }

    // 실제로 Item이 보여지는 부분
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomViewHolder holder;
        if (convertView == null) {

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_costom, null, false);

            holder = new CustomViewHolder();
            holder.textTitle = (TextView) convertView.findViewById(R.id.text_title);
            holder.textContent = (TextView) convertView.findViewById(R.id.text_content);
            convertView.setTag(holder);
        } else {
            holder = (CustomViewHolder) convertView.getTag();
        }

        DTO dto = listCustom.get(position);

        holder.textTitle.setText(dto.getTitle());
        holder.textContent.setText(dto.getContent());
        return convertView;
    }

    class CustomViewHolder {
        ImageView imageView;
        TextView textTitle;
        TextView textContent;
    }
    public void addItem(DTO dto) {
        listCustom.add(dto);
        notifyDataSetChanged();
    }
    public void clear() {
        listCustom.clear();
    }
}