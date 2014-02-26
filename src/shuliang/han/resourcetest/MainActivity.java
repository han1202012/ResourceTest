package shuliang.han.resourcetest;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private String[] array_string;
	private int[] array_int;
	private TypedArray colors;
	private ListView listView;
	private Resources res;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//��ȡresource����
		res = getResources();
		//��ȡ�ַ�����Դ
		array_string = res.getStringArray(R.array.string_array);
		//��ȡ����������Դ
		array_int = res.getIntArray(R.array.integer_array);
		//��ȡ��ɫ��Դ
		colors = res.obtainTypedArray(R.array.color_array);
		
		listView = (ListView) findViewById(R.id.lv);
		listView.setAdapter(new MyBaseAdapter());
		
	}
	
	/*
	 * ListView������
	 */
	class MyBaseAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return array_string.length;
		}

		@Override
		public Object getItem(int position) {
			return array_string[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			//����TextView, �����ÿ��
			TextView textView = new TextView(getApplicationContext());
			textView.setHeight((int) res.getDimension(R.dimen.tv_height));
			textView.setWidth((int) res.getDimension(R.dimen.tv_width));
			
			//ΪTextView�����ı�
			textView.setText(array_int[position] + ". " + array_string[position]);
			//����TextView�ı��� ����
			textView.setBackgroundDrawable(colors.getDrawable(position));
			textView.setTextSize(20);
			return textView;
		}
	}
}
