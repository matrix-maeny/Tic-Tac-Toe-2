package com.matrix_maeny.tictactoe2.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.matrix_maeny.tictactoe2.fragments.SinglePlayerFragment;
import com.matrix_maeny.tictactoe2.fragments.TwoPlayerFragment;

public class FragmentAdapter extends FragmentStateAdapter {

    final String[] titles = {"TWO PLAYERS", "SINGLE PLAYER"};

    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0) return new SinglePlayerFragment();
        else return new TwoPlayerFragment();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
