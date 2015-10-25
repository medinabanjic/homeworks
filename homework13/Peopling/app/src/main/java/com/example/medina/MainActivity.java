package com.example.medina;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    private static PersonList personList = new PersonList();
    private EditText mNameText;
    private EditText mSurnameText;
    private Button mAddButton;
    private RecyclerView mRecyclerView;
    private PersonAdapter mPersonAdapter;
    private RadioButton mSortByNameButton;
    private RadioButton mSortBySurnameButton;
    private MyCustomLayoutManager mLayoutManager;
    private int position;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.medina.R.layout.activity_main_layout);

        mNameText = (EditText) findViewById(com.example.medina.R.id.insert_name);
        mSurnameText = (EditText) findViewById(com.example.medina.R.id.insert_surname);
        mAddButton = (Button) findViewById(com.example.medina.R.id.add_button);

        mRecyclerView = (RecyclerView) findViewById(com.example.medina.R.id.recycler);
        mPersonAdapter = new PersonAdapter(personList);
        mRecyclerView.setAdapter(mPersonAdapter);
        mLayoutManager = new MyCustomLayoutManager(getBaseContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.smoothScrollToPosition(position);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable name = mNameText.getText();
                Editable surname = mSurnameText.getText();
                if (!name.toString().equals("") && !surname.toString().equals("")) {
                    personList.addPerson(name, surname);
                    mPersonAdapter.notifyDataSetChanged();
                    mNameText.setText("");
                    mSurnameText.setText("");
                    refresh();
                } else {
                    Toast.makeText(MainActivity.this, "Your input is wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mSortByNameButton = (RadioButton) findViewById(com.example.medina.R.id.radioButton1);
        mSortBySurnameButton = (RadioButton) findViewById(com.example.medina.R.id.radioButton2);
        mSortByNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSortBySurnameButton.setChecked(!mSortByNameButton.isChecked());
                if (personList.getSize() != 0) {
                    personList.sortByName();
                    refresh();
                }
            }
        });
        mSortBySurnameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSortByNameButton.setChecked(!mSortBySurnameButton.isChecked());
                if (personList.getSize() != 0) {
                    personList.sortBySurname();
                    refresh();
                }
            }
        });
    }

    private class PersonView extends RecyclerView.ViewHolder{
        private TextView nameText;
        private TextView surnameText;
        private TextView dateText;
        private Button removeButton;
        private Button editButton;


        public PersonView(View itemView) {
            super(itemView);

            nameText = (TextView) itemView.findViewById(com.example.medina.R.id.person_name);
            surnameText = (TextView) itemView.findViewById(com.example.medina.R.id.person_surname);
            dateText = (TextView) itemView.findViewById(com.example.medina.R.id.person_date);
            removeButton = (Button) itemView.findViewById(com.example.medina.R.id.remove_button);
            editButton = (Button) itemView.findViewById(com.example.medina.R.id.edit_button);


        }


    }

    private class PersonAdapter extends RecyclerView.Adapter<PersonView> {

        private PersonList personList;
        private EditText editNameText;
        private EditText editSurnameText;
        private Button editButton1;

        public PersonAdapter(PersonList personList){
            this.personList = personList;
        }


        @Override
        public PersonView onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);

            View view = layoutInflater.inflate(com.example.medina.R.layout.person_layout, parent, false);
            return new PersonView(view);
        }

        @Override
        public void onBindViewHolder(final PersonView holder, int position) {
            final PersonModel person = personList.getPerson(position);

            holder.nameText.setText(person.getName());
            holder.surnameText.setText(person.getSurname());
            holder.dateText.setText(person.getDateAdded().toString());
            holder.removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    //vidjela od kolege, budimo iskreni
                    alert.setTitle("Are you sure?");

                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            personList.removePerson(person.getID());
                            refresh();
                        }
                    });

                    alert.setNegativeButton("No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    dialog.cancel();
                                }
                            });

                    alert.show();

                }
            });

            LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            final Dialog commentDialog = new Dialog(MainActivity.this);
            holder.editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    commentDialog.setContentView(com.example.medina.R.layout.edit_person_layout);
                    editNameText = (EditText) commentDialog.findViewById(com.example.medina.R.id.edit_name);
                    editSurnameText = (EditText) commentDialog.findViewById(com.example.medina.R.id.edit_surname);
                    editNameText.setText(person.getName());
                    editSurnameText.setText(person.getSurname());
                    editButton1 = (Button) commentDialog.findViewById(com.example.medina.R.id.edit_button1);
                    editButton1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (!editNameText.getText().toString().equals("") && !editSurnameText.getText().toString().equals("")) {
                                holder.nameText.setText(editNameText.getText());
                                holder.surnameText.setText(editSurnameText.getText());
                                personList.updatePerson(person.getID(), editNameText.getText().toString(), editSurnameText.getText().toString());
                                refresh();
                                commentDialog.dismiss();
                            } else {
                                Toast.makeText(MainActivity.this, "Your input is wrong!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    commentDialog.show();
                    refresh();
                }
            });
        }

        @Override
        public int getItemCount() {
            return personList.getSize();
        }

    }

    private void refresh() {
        mPersonAdapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(mPersonAdapter);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Exit?");

        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                MainActivity.this.finish();
            }
        });

        alert.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    dialog.cancel();
                    }
                });

        alert.show();

    }

    public class MyCustomLayoutManager extends LinearLayoutManager {
        private static final float MILLISECONDS_PER_INCH = 50f;
        private Context mContext;

        public MyCustomLayoutManager(Context context) {
            super(context);
            mContext = context;
        }

        @Override
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, final int position) {
            super.smoothScrollToPosition(recyclerView, state, position);

            LinearSmoothScroller smoothScroller = new LinearSmoothScroller(mContext) {

                //This controls the direction in which smoothScroll looks for your view
                @Override
                public PointF computeScrollVectorForPosition(int targetPosition) {
                    return new PointF(0, 1);
                }

                //This returns the milliseconds it takes to scroll one pixel.
                @Override
                protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                    return MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
                }
            };

            smoothScroller.setTargetPosition(position);
            startSmoothScroll(smoothScroller);
        }
    }



}
