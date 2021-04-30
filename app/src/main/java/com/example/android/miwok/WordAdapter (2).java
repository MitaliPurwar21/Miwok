package com.example.android.miwok;

/**
 * Created by Dell on 17-03-2017.
 *
 */
import android.widget.ArrayAdapter;
import android.app.Activity;
import java.util.ArrayList;
import android.view.View;
import android.view.ViewGroup;
import android .view.LayoutInflater;
import android.widget.TextView;
import android.widget.ImageView;
import android.support.v4.content.ContextCompat;


public class WordAdapter extends ArrayAdapter<Word> {


    //resource id for background color for this list of word
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words,int ColorResourceId){
        // here we initialize the ArrayAdapter's internal storage for the context and the list.
        //the second argument is used when the ArrayAdapter is populating a single TextView.
        //because this is a custom adapter two TextView and an ImageView the adapter is
        //is going to used this second argument, so it can be any value.here we used 0.
        super(context, 0,words);
        mColorResourceId = ColorResourceId;
    }
    @Override
    public View getView(int position, View convertView,ViewGroup parent){

// check the existing view group is being resused, other wise inflate the view
        View ListItemView = convertView;
        if(ListItemView == null){
            ListItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }
        //get the{@link word} object located at this position in the list
        Word currentWord = getItem(position);

        //find the text view in the list_item.xml layout with the id miwok
        TextView miwokTextView = (TextView) ListItemView.findViewById(R.id.miwok_text_view);

        //get the version from the current word object and set this text in miwok translation
        miwokTextView.setText(currentWord.getmMiwokTranslation());

        TextView defaultTextView = (TextView) ListItemView.findViewById(R.id.default_text_view);

        defaultTextView.setText(currentWord.getmDefaultTranslation());


        // Find the ImageView in the list_item.xml layout with the ID image.
               ImageView imageView = (ImageView) ListItemView.findViewById(R.id.image);

          if(currentWord.hasImage()) {

              // Set the ImageView to the image resource specified in the current Word
              imageView.setImageResource(currentWord.getImageResourceId());

              // Make sure the view is visible
              imageView.setVisibility(View.VISIBLE);
          }
          else{
              // Otherwise hide the ImageView (set visibility to GONE)
              imageView.setVisibility(View.GONE);
          }

         //set the theme for the list item
        View textContainer = ListItemView.findViewById(R.id.text_container);

        // find the color that resource id maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.

             return ListItemView;
    }




}
