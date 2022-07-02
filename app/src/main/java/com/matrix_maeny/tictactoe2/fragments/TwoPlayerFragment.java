package com.matrix_maeny.tictactoe2.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.matrix_maeny.tictactoe2.HelpActivity;
import com.matrix_maeny.tictactoe2.R;
import com.matrix_maeny.tictactoe2.databinding.FragmentTwoPlayerBinding;

import java.util.Objects;


public class TwoPlayerFragment extends Fragment {

    FragmentTwoPlayerBinding binding;

    int turnNumber = 1;
    int t11 = 0, t12 = 0, t13 = 0, t14 = 0, t15 = 0, t16 = 0, t17 = 0, t18 = 0, t19 = 0, t21 = 0, t22 = 0, t23 = 0, t24 = 0, t25 = 0, t26 = 0, t27 = 0, t28 = 0, t29 = 0, t31 = 0, t32 = 0, t33 = 0, t34 = 0, t35 = 0, t36 = 0, t37 = 0, t38 = 0, t39 = 0;
    int t41 = 0, t42 = 0, t43 = 0, t44 = 0, t45 = 0, t46 = 0, t47 = 0, t48 = 0, t49 = 0, t51 = 0, t52 = 0, t53 = 0, t54 = 0, t55 = 0, t56 = 0, t57 = 0, t58 = 0, t59 = 0, t61 = 0, t62 = 0, t63 = 0, t64 = 0, t65 = 0, t66 = 0, t67 = 0, t68 = 0, t69 = 0;
    int t71 = 0, t72 = 0, t73 = 0, t74 = 0, t75 = 0, t76 = 0, t77 = 0, t78 = 0, t79 = 0, t81 = 0, t82 = 0, t83 = 0, t84 = 0, t85 = 0, t86 = 0, t87 = 0, t88 = 0, t89 = 0, t91 = 0, t92 = 0, t93 = 0, t94 = 0, t95 = 0, t96 = 0, t97 = 0, t98 = 0, t99 = 0;
    int t101 = 0, t102 = 0, t103 = 0, t104 = 0, t105 = 0, t106 = 0, t107 = 0, t108 = 0, t109 = 0, t111 = 0, t112 = 0, t113 = 0, t114 = 0, t115 = 0, t116 = 0, t117 = 0, t118 = 0, t119 = 0, t121 = 0, t122 = 0, t123 = 0, t124 = 0, t125 = 0, t126 = 0, t127 = 0, t128 = 0, t129 = 0;
    int player1Score = 0, player2Score = 0;

    boolean gameStatus = true, sounds = true;
    boolean restartChecker = false;
    boolean turnChanger = false;
    ImageView[][] matrixViews = null;
    MediaPlayer player = null;
    boolean colorSign = false;
    int i = 0, pivot = 0;


    public TwoPlayerFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTwoPlayerBinding.inflate(inflater, container, false);

        matrixViews = new ImageView[][]{
                // all image views (boxes)
                {binding.tic11View, binding.tic12View, binding.tic13View, binding.tic14View, binding.tic15View, binding.tic16View, binding.tic17View, binding.tic18View, binding.tic19View},
                {binding.tic21View, binding.tic22View, binding.tic23View, binding.tic24View, binding.tic25View, binding.tic26View, binding.tic27View, binding.tic28View, binding.tic29View},
                {binding.tic31View, binding.tic32View, binding.tic33View, binding.tic34View, binding.tic35View, binding.tic36View, binding.tic37View, binding.tic38View, binding.tic39View},
                {binding.tic41View, binding.tic42View, binding.tic43View, binding.tic44View, binding.tic45View, binding.tic46View, binding.tic47View, binding.tic48View, binding.tic49View},
                {binding.tic51View, binding.tic52View, binding.tic53View, binding.tic54View, binding.tic55View, binding.tic56View, binding.tic57View, binding.tic58View, binding.tic59View},
                {binding.tic61View, binding.tic62View, binding.tic63View, binding.tic64View, binding.tic65View, binding.tic66View, binding.tic67View, binding.tic68View, binding.tic69View},
                {binding.tic71View, binding.tic72View, binding.tic73View, binding.tic74View, binding.tic75View, binding.tic76View, binding.tic77View, binding.tic78View, binding.tic79View},
                {binding.tic81View, binding.tic82View, binding.tic83View, binding.tic84View, binding.tic85View, binding.tic86View, binding.tic87View, binding.tic88View, binding.tic89View},
                {binding.tic91View, binding.tic92View, binding.tic93View, binding.tic94View, binding.tic95View, binding.tic96View, binding.tic97View, binding.tic98View, binding.tic99View},
                {binding.tic101View, binding.tic102View, binding.tic103View, binding.tic104View, binding.tic105View, binding.tic106View, binding.tic107View, binding.tic108View, binding.tic109View},
                {binding.tic111View, binding.tic112View, binding.tic113View, binding.tic114View, binding.tic115View, binding.tic116View, binding.tic117View, binding.tic118View, binding.tic119View},
                {binding.tic121View, binding.tic122View, binding.tic123View, binding.tic124View, binding.tic125View, binding.tic126View, binding.tic127View, binding.tic128View, binding.tic129View},


        };
        binding.soundSwitch.setChecked(true);

        setTheVisibility();
        setTheListeners();
        Toast.makeText(getContext(), "Check turn and start Game", Toast.LENGTH_LONG).show();
        return binding.getRoot();//inflater.inflate(R.layout.fragment_two_player, container, false);


    }

    // for the initial visibility of the players
    @SuppressLint("SetTextI18n")
    final void setTheVisibility() {
        binding.soundSwitch.setVisibility(View.VISIBLE);

        binding.wonDialog.setVisibility(View.INVISIBLE);
        binding.restartBtn.setVisibility(View.VISIBLE);
        binding.linearLayout2.setVisibility(View.VISIBLE);
        binding.gameBoard.setVisibility(View.VISIBLE);

        binding.tic11View.setVisibility(View.INVISIBLE); // row 1
        binding.tic12View.setVisibility(View.INVISIBLE);
        binding.tic13View.setVisibility(View.INVISIBLE);
        binding.tic14View.setVisibility(View.INVISIBLE);
        binding.tic15View.setVisibility(View.INVISIBLE);
        binding.tic16View.setVisibility(View.INVISIBLE);
        binding.tic17View.setVisibility(View.INVISIBLE);
        binding.tic18View.setVisibility(View.INVISIBLE);
        binding.tic19View.setVisibility(View.INVISIBLE);

        binding.tic21View.setVisibility(View.INVISIBLE); // row 2
        binding.tic22View.setVisibility(View.INVISIBLE);
        binding.tic23View.setVisibility(View.INVISIBLE);
        binding.tic24View.setVisibility(View.INVISIBLE);
        binding.tic25View.setVisibility(View.INVISIBLE);
        binding.tic26View.setVisibility(View.INVISIBLE);
        binding.tic27View.setVisibility(View.INVISIBLE);
        binding.tic28View.setVisibility(View.INVISIBLE);
        binding.tic29View.setVisibility(View.INVISIBLE);

        binding.tic31View.setVisibility(View.INVISIBLE); // row 3
        binding.tic32View.setVisibility(View.INVISIBLE);
        binding.tic33View.setVisibility(View.INVISIBLE);
        binding.tic34View.setVisibility(View.INVISIBLE);
        binding.tic35View.setVisibility(View.INVISIBLE);
        binding.tic36View.setVisibility(View.INVISIBLE);
        binding.tic37View.setVisibility(View.INVISIBLE);
        binding.tic38View.setVisibility(View.INVISIBLE);
        binding.tic39View.setVisibility(View.INVISIBLE);

        binding.tic41View.setVisibility(View.INVISIBLE); // row 4
        binding.tic42View.setVisibility(View.INVISIBLE);
        binding.tic43View.setVisibility(View.INVISIBLE);
        binding.tic44View.setVisibility(View.INVISIBLE);
        binding.tic45View.setVisibility(View.INVISIBLE);
        binding.tic46View.setVisibility(View.INVISIBLE);
        binding.tic47View.setVisibility(View.INVISIBLE);
        binding.tic48View.setVisibility(View.INVISIBLE);
        binding.tic49View.setVisibility(View.INVISIBLE);

        binding.tic51View.setVisibility(View.INVISIBLE); // row 5
        binding.tic52View.setVisibility(View.INVISIBLE);
        binding.tic53View.setVisibility(View.INVISIBLE);
        binding.tic54View.setVisibility(View.INVISIBLE);
        binding.tic55View.setVisibility(View.INVISIBLE);
        binding.tic56View.setVisibility(View.INVISIBLE);
        binding.tic57View.setVisibility(View.INVISIBLE);
        binding.tic58View.setVisibility(View.INVISIBLE);
        binding.tic59View.setVisibility(View.INVISIBLE);

        binding.tic61View.setVisibility(View.INVISIBLE); // row 6
        binding.tic62View.setVisibility(View.INVISIBLE);
        binding.tic63View.setVisibility(View.INVISIBLE);
        binding.tic64View.setVisibility(View.INVISIBLE);
        binding.tic65View.setVisibility(View.INVISIBLE);
        binding.tic66View.setVisibility(View.INVISIBLE);
        binding.tic67View.setVisibility(View.INVISIBLE);
        binding.tic68View.setVisibility(View.INVISIBLE);
        binding.tic69View.setVisibility(View.INVISIBLE);

        binding.tic71View.setVisibility(View.INVISIBLE); // row 7
        binding.tic72View.setVisibility(View.INVISIBLE);
        binding.tic73View.setVisibility(View.INVISIBLE);
        binding.tic74View.setVisibility(View.INVISIBLE);
        binding.tic75View.setVisibility(View.INVISIBLE);
        binding.tic76View.setVisibility(View.INVISIBLE);
        binding.tic77View.setVisibility(View.INVISIBLE);
        binding.tic78View.setVisibility(View.INVISIBLE);
        binding.tic79View.setVisibility(View.INVISIBLE);

        binding.tic81View.setVisibility(View.INVISIBLE); // row 8
        binding.tic82View.setVisibility(View.INVISIBLE);
        binding.tic83View.setVisibility(View.INVISIBLE);
        binding.tic84View.setVisibility(View.INVISIBLE);
        binding.tic85View.setVisibility(View.INVISIBLE);
        binding.tic86View.setVisibility(View.INVISIBLE);
        binding.tic87View.setVisibility(View.INVISIBLE);
        binding.tic88View.setVisibility(View.INVISIBLE);
        binding.tic89View.setVisibility(View.INVISIBLE);

        binding.tic91View.setVisibility(View.INVISIBLE); // row 9
        binding.tic92View.setVisibility(View.INVISIBLE);
        binding.tic93View.setVisibility(View.INVISIBLE);
        binding.tic94View.setVisibility(View.INVISIBLE);
        binding.tic95View.setVisibility(View.INVISIBLE);
        binding.tic96View.setVisibility(View.INVISIBLE);
        binding.tic97View.setVisibility(View.INVISIBLE);
        binding.tic98View.setVisibility(View.INVISIBLE);
        binding.tic99View.setVisibility(View.INVISIBLE);

        binding.tic101View.setVisibility(View.INVISIBLE); // row 10
        binding.tic102View.setVisibility(View.INVISIBLE);
        binding.tic103View.setVisibility(View.INVISIBLE);
        binding.tic104View.setVisibility(View.INVISIBLE);
        binding.tic105View.setVisibility(View.INVISIBLE);
        binding.tic106View.setVisibility(View.INVISIBLE);
        binding.tic107View.setVisibility(View.INVISIBLE);
        binding.tic108View.setVisibility(View.INVISIBLE);
        binding.tic109View.setVisibility(View.INVISIBLE);

        binding.tic111View.setVisibility(View.INVISIBLE); // row 11
        binding.tic112View.setVisibility(View.INVISIBLE);
        binding.tic113View.setVisibility(View.INVISIBLE);
        binding.tic114View.setVisibility(View.INVISIBLE);
        binding.tic115View.setVisibility(View.INVISIBLE);
        binding.tic116View.setVisibility(View.INVISIBLE);
        binding.tic117View.setVisibility(View.INVISIBLE);
        binding.tic118View.setVisibility(View.INVISIBLE);
        binding.tic119View.setVisibility(View.INVISIBLE);

        binding.tic121View.setVisibility(View.INVISIBLE); // row 12
        binding.tic122View.setVisibility(View.INVISIBLE);
        binding.tic123View.setVisibility(View.INVISIBLE);
        binding.tic124View.setVisibility(View.INVISIBLE);
        binding.tic125View.setVisibility(View.INVISIBLE);
        binding.tic126View.setVisibility(View.INVISIBLE);
        binding.tic127View.setVisibility(View.INVISIBLE);
        binding.tic128View.setVisibility(View.INVISIBLE);
        binding.tic129View.setVisibility(View.INVISIBLE);

        binding.player1Score.setText(": 00");
        binding.player2Score.setText(": 00");
        binding.soundSwitch.setChecked(true);
    }

    final void setTheListeners() {
        binding.information.setOnClickListener(helpListener);


        binding.playAgain.setOnClickListener(restartGameListener);
        binding.tic11.setOnClickListener(tic11Listener); // row 1
        binding.tic12.setOnClickListener(tic12Listener);
        binding.tic13.setOnClickListener(tic13Listener);
        binding.tic14.setOnClickListener(tic14Listener);
        binding.tic15.setOnClickListener(tic15Listener);
        binding.tic16.setOnClickListener(tic16Listener);
        binding.tic17.setOnClickListener(tic17Listener);
        binding.tic18.setOnClickListener(tic18Listener);
        binding.tic19.setOnClickListener(tic19Listener);

        binding.tic21.setOnClickListener(tic21Listener); // row 2
        binding.tic22.setOnClickListener(tic22Listener);
        binding.tic23.setOnClickListener(tic23Listener);
        binding.tic24.setOnClickListener(tic24Listener);
        binding.tic25.setOnClickListener(tic25Listener);
        binding.tic26.setOnClickListener(tic26Listener);
        binding.tic27.setOnClickListener(tic27Listener);
        binding.tic28.setOnClickListener(tic28Listener);
        binding.tic29.setOnClickListener(tic29Listener);

        binding.tic31.setOnClickListener(tic31Listener); // row 3
        binding.tic32.setOnClickListener(tic32Listener);
        binding.tic33.setOnClickListener(tic33Listener);
        binding.tic34.setOnClickListener(tic34Listener);
        binding.tic35.setOnClickListener(tic35Listener);
        binding.tic36.setOnClickListener(tic36Listener);
        binding.tic37.setOnClickListener(tic37Listener);
        binding.tic38.setOnClickListener(tic38Listener);
        binding.tic39.setOnClickListener(tic39Listener);

        binding.tic41.setOnClickListener(tic41Listener); // row 4
        binding.tic42.setOnClickListener(tic42Listener);
        binding.tic43.setOnClickListener(tic43Listener);
        binding.tic44.setOnClickListener(tic44Listener);
        binding.tic45.setOnClickListener(tic45Listener);
        binding.tic46.setOnClickListener(tic46Listener);
        binding.tic47.setOnClickListener(tic47Listener);
        binding.tic48.setOnClickListener(tic48Listener);
        binding.tic49.setOnClickListener(tic49Listener);

        binding.tic51.setOnClickListener(tic51Listener); // row 5
        binding.tic52.setOnClickListener(tic52Listener);
        binding.tic53.setOnClickListener(tic53Listener);
        binding.tic54.setOnClickListener(tic54Listener);
        binding.tic55.setOnClickListener(tic55Listener);
        binding.tic56.setOnClickListener(tic56Listener);
        binding.tic57.setOnClickListener(tic57Listener);
        binding.tic58.setOnClickListener(tic58Listener);
        binding.tic59.setOnClickListener(tic59Listener);

        binding.tic61.setOnClickListener(tic61Listener); // row 6
        binding.tic62.setOnClickListener(tic62Listener);
        binding.tic63.setOnClickListener(tic63Listener);
        binding.tic64.setOnClickListener(tic64Listener);
        binding.tic65.setOnClickListener(tic65Listener);
        binding.tic66.setOnClickListener(tic66Listener);
        binding.tic67.setOnClickListener(tic67Listener);
        binding.tic68.setOnClickListener(tic68Listener);
        binding.tic69.setOnClickListener(tic69Listener);

        binding.tic71.setOnClickListener(tic71Listener); // row 7
        binding.tic72.setOnClickListener(tic72Listener);
        binding.tic73.setOnClickListener(tic73Listener);
        binding.tic74.setOnClickListener(tic74Listener);
        binding.tic75.setOnClickListener(tic75Listener);
        binding.tic76.setOnClickListener(tic76Listener);
        binding.tic77.setOnClickListener(tic77Listener);
        binding.tic78.setOnClickListener(tic78Listener);
        binding.tic79.setOnClickListener(tic79Listener);

        binding.tic81.setOnClickListener(tic81Listener); // row 8
        binding.tic82.setOnClickListener(tic82Listener);
        binding.tic83.setOnClickListener(tic83Listener);
        binding.tic84.setOnClickListener(tic84Listener);
        binding.tic85.setOnClickListener(tic85Listener);
        binding.tic86.setOnClickListener(tic86Listener);
        binding.tic87.setOnClickListener(tic87Listener);
        binding.tic88.setOnClickListener(tic88Listener);
        binding.tic89.setOnClickListener(tic89Listener);

        binding.tic91.setOnClickListener(tic91Listener); // row 9
        binding.tic92.setOnClickListener(tic92Listener);
        binding.tic93.setOnClickListener(tic93Listener);
        binding.tic94.setOnClickListener(tic94Listener);
        binding.tic95.setOnClickListener(tic95Listener);
        binding.tic96.setOnClickListener(tic96Listener);
        binding.tic97.setOnClickListener(tic97Listener);
        binding.tic98.setOnClickListener(tic98Listener);
        binding.tic99.setOnClickListener(tic99Listener);

        binding.tic101.setOnClickListener(tic101Listener); // row 10
        binding.tic102.setOnClickListener(tic102Listener);
        binding.tic103.setOnClickListener(tic103Listener);
        binding.tic104.setOnClickListener(tic104Listener);
        binding.tic105.setOnClickListener(tic105Listener);
        binding.tic106.setOnClickListener(tic106Listener);
        binding.tic107.setOnClickListener(tic107Listener);
        binding.tic108.setOnClickListener(tic108Listener);
        binding.tic109.setOnClickListener(tic109Listener);

        binding.tic111.setOnClickListener(tic111Listener); // row 11
        binding.tic112.setOnClickListener(tic112Listener);
        binding.tic113.setOnClickListener(tic113Listener);
        binding.tic114.setOnClickListener(tic114Listener);
        binding.tic115.setOnClickListener(tic115Listener);
        binding.tic116.setOnClickListener(tic116Listener);
        binding.tic117.setOnClickListener(tic117Listener);
        binding.tic118.setOnClickListener(tic118Listener);
        binding.tic119.setOnClickListener(tic119Listener);

        binding.tic121.setOnClickListener(tic121Listener); // row 12
        binding.tic122.setOnClickListener(tic122Listener);
        binding.tic123.setOnClickListener(tic123Listener);
        binding.tic124.setOnClickListener(tic124Listener);
        binding.tic125.setOnClickListener(tic125Listener);
        binding.tic126.setOnClickListener(tic126Listener);
        binding.tic127.setOnClickListener(tic127Listener);
        binding.tic128.setOnClickListener(tic128Listener);
        binding.tic129.setOnClickListener(tic129Listener);

        // for game restart
        binding.restartBtn.setOnClickListener(restartGameListener);
        binding.soundSwitch.setOnCheckedChangeListener(switchListener);
        binding.playAgain.setOnClickListener(restartGameListener);

    }


    //onclick listeners for all boxes
    View.OnClickListener helpListener = v -> {
        if (sounds)
            playRestartSound();
        startActivity(new Intent(requireContext().getApplicationContext(), HelpActivity.class));
    };
    View.OnClickListener tic11Listener = v -> {
        if (t11 == 0) {
            if (!colorSign)
                startTic11();
        } else showAlreadyFilled();
    }; // row 1
    View.OnClickListener tic12Listener = v -> {
        if (t12 == 0) {
            if (!colorSign)
                startTic12();
        } else showAlreadyFilled();

    };
    View.OnClickListener tic13Listener = v -> {
        if (t13 == 0) {
            if (!colorSign)
                startTic13();
        } else showAlreadyFilled();

    };
    View.OnClickListener tic14Listener = v -> {
        if (t14 == 0) {
            if (!colorSign)
                startTic14();
        } else showAlreadyFilled();

    };
    View.OnClickListener tic15Listener = v -> {
        if (t15 == 0) {
            if (!colorSign)
                startTic15();
        } else showAlreadyFilled();

    };
    View.OnClickListener tic16Listener = v -> {
        if (t16 == 0) {
            if (!colorSign)
                startTic16();
        } else showAlreadyFilled();

    };
    View.OnClickListener tic17Listener = v -> {
        if (t17 == 0) {
            if (!colorSign)
                startTic17();
        } else showAlreadyFilled();

    };
    View.OnClickListener tic18Listener = v -> {
        if (t18 == 0) {
            if (!colorSign)
                startTic18();
        } else showAlreadyFilled();

    };
    View.OnClickListener tic19Listener = v -> {
        if (t19 == 0) {
            if (!colorSign)
                startTic19();
        } else showAlreadyFilled();

    };

    View.OnClickListener tic21Listener = v -> {
        if (t21 == 0) {
            if (!colorSign)
                startTic21();
        } else showAlreadyFilled();

    }; // row 2
    View.OnClickListener tic22Listener = v -> {
        if (t22 == 0) {
            if (!colorSign)
                startTic22();
        } else showAlreadyFilled();

    };
    View.OnClickListener tic23Listener = v -> {
        if (t23 == 0) {
            if (!colorSign)
                startTic23();
        } else showAlreadyFilled();

    };
    View.OnClickListener tic24Listener = v -> {
        if (t24 == 0) {
            if (!colorSign)
                startTic24();
        } else showAlreadyFilled();

    };
    View.OnClickListener tic25Listener = v -> {
        if (t25 == 0) {
            if (!colorSign)
                startTic25();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic26Listener = v -> {
        if (t26 == 0) {
            if (!colorSign)
                startTic26();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic27Listener = v -> {
        if (t27 == 0) {
            if (!colorSign)
                startTic27();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic28Listener = v -> {
        if (t28 == 0) {
            if (!colorSign)
                startTic28();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic29Listener = v -> {
        if (t29 == 0) {
            if (!colorSign)
                startTic29();
        } else showAlreadyFilled();
    };

    View.OnClickListener tic31Listener = v -> {
        if (t31 == 0) {
            if (!colorSign)
                startTic31();
        } else showAlreadyFilled();
    }; // row 3
    View.OnClickListener tic32Listener = v -> {
        if (t32 == 0) {
            if (!colorSign)
                startTic32();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic33Listener = v -> {
        if (t33 == 0) {
            if (!colorSign)
                startTic33();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic34Listener = v -> {
        if (t34 == 0) {
            if (!colorSign)
                startTic34();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic35Listener = v -> {
        if (t35 == 0) {
            if (!colorSign)
                startTic35();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic36Listener = v -> {
        if (t36 == 0) {
            if (!colorSign)
                startTic36();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic37Listener = v -> {
        if (t37 == 0) {
            if (!colorSign)
                startTic37();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic38Listener = v -> {
        if (t38 == 0) {
            if (!colorSign)
                startTic38();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic39Listener = v -> {
        if (t39 == 0) {
            if (!colorSign)
                startTic39();
        } else showAlreadyFilled();
    };

    View.OnClickListener tic41Listener = v -> {
        if (t41 == 0) {
            if (!colorSign)
                startTic41();
        } else showAlreadyFilled();
    }; // row 4
    View.OnClickListener tic42Listener = v -> {
        if (t42 == 0) {
            if (!colorSign)
                startTic42();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic43Listener = v -> {
        if (t43 == 0) {
            if (!colorSign)
                startTic43();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic44Listener = v -> {
        if (t44 == 0) {
            if (!colorSign)
                startTic44();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic45Listener = v -> {
        if (t45 == 0) {
            if (!colorSign)
                startTic45();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic46Listener = v -> {
        if (t46 == 0) {
            if (!colorSign)
                startTic46();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic47Listener = v -> {
        if (t47 == 0) {
            if (!colorSign)
                startTic47();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic48Listener = v -> {
        if (t48 == 0) {
            if (!colorSign)
                startTic48();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic49Listener = v -> {
        if (t49 == 0) {
            if (!colorSign)
                startTic49();
        } else showAlreadyFilled();
    };

    View.OnClickListener tic51Listener = v -> {
        if (t51 == 0) {
            if (!colorSign)
                startTic51();
        } else showAlreadyFilled();
    }; // row 5
    View.OnClickListener tic52Listener = v -> {
        if (t52 == 0) {
            if (!colorSign)
                startTic52();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic53Listener = v -> {
        if (t53 == 0) {
            if (!colorSign)
                startTic53();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic54Listener = v -> {
        if (t54 == 0) {
            if (!colorSign)
                startTic54();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic55Listener = v -> {
        if (t55 == 0) {
            if (!colorSign)
                startTic55();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic56Listener = v -> {
        if (t56 == 0) {
            if (!colorSign)
                startTic56();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic57Listener = v -> {
        if (t57 == 0) {
            if (!colorSign)
                startTic57();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic58Listener = v -> {
        if (t58 == 0) {
            startTic58();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic59Listener = v -> {
        if (t59 == 0) {
            if (!colorSign)
                startTic59();
        } else showAlreadyFilled();
    };

    View.OnClickListener tic61Listener = v -> {
        if (t61 == 0) {
            if (!colorSign)
                startTic61();
        } else showAlreadyFilled();
    }; // row 6
    View.OnClickListener tic62Listener = v -> {
        if (t62 == 0) {
            if (!colorSign)
                startTic62();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic63Listener = v -> {
        if (t63 == 0) {
            if (!colorSign)
                startTic63();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic64Listener = v -> {
        if (t64 == 0) {
            startTic64();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic65Listener = v -> {
        if (t65 == 0) {
            if (!colorSign)
                startTic65();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic66Listener = v -> {
        if (t66 == 0) {
            if (!colorSign)
                startTic66();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic67Listener = v -> {
        if (t67 == 0) {
            if (!colorSign)
                startTic67();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic68Listener = v -> {
        if (t68 == 0) {
            if (!colorSign)
                startTic68();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic69Listener = v -> {
        if (t69 == 0) {
            if (!colorSign)
                startTic69();
        } else showAlreadyFilled();
    };

    View.OnClickListener tic71Listener = v -> {
        if (t71 == 0) {
            if (!colorSign)
                startTic71();
        } else showAlreadyFilled();
    }; // row 7
    View.OnClickListener tic72Listener = v -> {
        if (t72 == 0) {
            if (!colorSign)
                startTic72();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic73Listener = v -> {
        if (t73 == 0) {
            if (!colorSign)
                startTic73();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic74Listener = v -> {
        if (t74 == 0) {
            if (!colorSign)
                startTic74();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic75Listener = v -> {
        if (t75 == 0) {
            if (!colorSign)
                startTic75();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic76Listener = v -> {
        if (t76 == 0) {
            if (!colorSign)
                startTic76();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic77Listener = v -> {
        if (t77 == 0) {
            if (!colorSign)
                startTic77();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic78Listener = v -> {
        if (t78 == 0) {
            if (!colorSign)
                startTic78();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic79Listener = v -> {
        if (t79 == 0) {
            if (!colorSign)
                startTic79();
        } else showAlreadyFilled();
    };

    View.OnClickListener tic81Listener = v -> {
        if (t81 == 0) {
            if (!colorSign)
                startTic81();
        } else showAlreadyFilled();
    }; // row 8
    View.OnClickListener tic82Listener = v -> {
        if (t82 == 0) {
            if (!colorSign)
                startTic82();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic83Listener = v -> {
        if (t83 == 0) {
            if (!colorSign)
                startTic83();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic84Listener = v -> {
        if (t84 == 0) {
            if (!colorSign)
                startTic84();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic85Listener = v -> {
        if (t85 == 0) {
            if (!colorSign)
                startTic85();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic86Listener = v -> {
        if (t86 == 0) {
            if (!colorSign)
                startTic86();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic87Listener = v -> {
        if (t87 == 0) {
            if (!colorSign)
                startTic87();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic88Listener = v -> {
        if (t88 == 0) {
            if (!colorSign)
                startTic88();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic89Listener = v -> {
        if (t89 == 0) {
            if (!colorSign)
                startTic89();
        } else showAlreadyFilled();
    };

    View.OnClickListener tic91Listener = v -> {
        if (t91 == 0) {
            if (!colorSign)
                startTic91();
        } else showAlreadyFilled();
    }; // row 9
    View.OnClickListener tic92Listener = v -> {
        if (t92 == 0) {
            if (!colorSign)
                startTic92();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic93Listener = v -> {
        if (t93 == 0) {
            if (!colorSign)
                startTic93();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic94Listener = v -> {
        if (t94 == 0) {
            if (!colorSign)
                startTic94();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic95Listener = v -> {
        if (t95 == 0) {
            if (!colorSign)
                startTic95();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic96Listener = v -> {
        if (t96 == 0) {
            if (!colorSign)
                startTic96();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic97Listener = v -> {
        if (t97 == 0) {
            if (!colorSign)
                startTic97();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic98Listener = v -> {
        if (t98 == 0) {
            if (!colorSign)
                startTic98();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic99Listener = v -> {
        if (t99 == 0) {
            if (!colorSign)
                startTic99();
        } else showAlreadyFilled();
    };

    View.OnClickListener tic101Listener = v -> {
        if (t101 == 0) {
            if (!colorSign)
                startTic101();
        } else showAlreadyFilled();
    }; // row 10
    View.OnClickListener tic102Listener = v -> {
        if (t102 == 0) {
            if (!colorSign)
                startTic102();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic103Listener = v -> {
        if (t103 == 0) {
            if (!colorSign)
                startTic103();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic104Listener = v -> {
        if (t104 == 0) {
            if (!colorSign)
                startTic104();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic105Listener = v -> {
        if (t105 == 0) {
            if (!colorSign)
                startTic105();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic106Listener = v -> {
        if (t106 == 0) {
            if (!colorSign)
                startTic106();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic107Listener = v -> {
        if (t107 == 0) {
            if (!colorSign)
                startTic107();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic108Listener = v -> {
        if (t108 == 0) {
            if (!colorSign)
                startTic108();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic109Listener = v -> {
        if (t109 == 0) {
            if (!colorSign)
                startTic109();
        } else showAlreadyFilled();
    };

    View.OnClickListener tic111Listener = v -> {
        if (t111 == 0) {
            if (!colorSign)
                startTic111();
        } else showAlreadyFilled();
    }; // row 11
    View.OnClickListener tic112Listener = v -> {
        if (t112 == 0) {
            if (!colorSign)
                startTic112();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic113Listener = v -> {
        if (t113 == 0) {
            if (!colorSign)
                startTic113();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic114Listener = v -> {
        if (t114 == 0) {
            if (!colorSign)
                startTic114();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic115Listener = v -> {
        if (t115 == 0) {
            if (!colorSign)
                startTic115();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic116Listener = v -> {
        if (t116 == 0) {
            if (!colorSign)
                startTic116();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic117Listener = v -> {
        if (t117 == 0) {
            if (!colorSign)
                startTic117();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic118Listener = v -> {
        if (t118 == 0) {
            if (!colorSign)
                startTic118();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic119Listener = v -> {
        if (t119 == 0) {
            if (!colorSign)
                startTic119();
        } else showAlreadyFilled();
    };

    View.OnClickListener tic121Listener = v -> {
        if (t121 == 0) {
            if (!colorSign)
                startTic121();
        } else showAlreadyFilled();
    }; // row 12
    View.OnClickListener tic122Listener = v -> {
        if (t122 == 0) {
            if (!colorSign)
                startTic122();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic123Listener = v -> {
        if (t123 == 0) {
            if (!colorSign)
                startTic123();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic124Listener = v -> {
        if (t124 == 0) {
            if (!colorSign)
                startTic124();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic125Listener = v -> {
        if (t125 == 0) {
            if (!colorSign)
                startTic125();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic126Listener = v -> {
        if (t126 == 0) {
            if (!colorSign)
                startTic126();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic127Listener = v -> {
        if (t127 == 0) {
            if (!colorSign)
                startTic127();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic128Listener = v -> {
        if (t128 == 0) {
            if (!colorSign)
                startTic128();
        } else showAlreadyFilled();
    };
    View.OnClickListener tic129Listener = v -> {
        if (t129 == 0) {
            if (!colorSign)
                startTic129();
        } else showAlreadyFilled();
    };

    View.OnClickListener restartGameListener = v -> {
        if (restartChecker) {
            restartGame();
        } else {
            Toast.makeText(getContext(), "Click again to restart", Toast.LENGTH_SHORT).show();
            restartChecker = true;
        }
    };
    MediaPlayer.OnCompletionListener playerListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            mp.release();
        }
    };
    CompoundButton.OnCheckedChangeListener switchListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                sounds = true;
            } else {
                sounds = false;
            }
        }
    };

    final void startTic11() {
        if (turnNumber == 1) {
            binding.tic11View.setImageResource(R.drawable.player_1);
        } else {
            binding.tic11View.setImageResource(R.drawable.player_2);
        }


        binding.tic11View.setVisibility(View.VISIBLE);
        t11 = turnNumber;
        checkResults(0, 0);

    }

    final void startTic12() {
        if (turnNumber == 1) {
            binding.tic12View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic12View.setImageResource(R.drawable.player_2);

        }


        binding.tic12View.setVisibility(View.VISIBLE);
        t12 = turnNumber;
        checkResults(0, 1);
    }

    final void startTic13() {
        if (turnNumber == 1) {
            binding.tic13View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic13View.setImageResource(R.drawable.player_2);

        }


        binding.tic13View.setVisibility(View.VISIBLE);
        t13 = turnNumber;
        checkResults(0, 2);
    }

    final void startTic14() {
        if (turnNumber == 1) {
            binding.tic14View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic14View.setImageResource(R.drawable.player_2);

        }


        binding.tic14View.setVisibility(View.VISIBLE);
        t14 = turnNumber;
        checkResults(0, 3);
    }

    final void startTic15() {
        if (turnNumber == 1) {
            binding.tic15View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic15View.setImageResource(R.drawable.player_2);

        }


        binding.tic15View.setVisibility(View.VISIBLE);
        t15 = turnNumber;
        checkResults(0, 4);
    }

    final void startTic16() {
        if (turnNumber == 1) {
            binding.tic16View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic16View.setImageResource(R.drawable.player_2);

        }


        binding.tic16View.setVisibility(View.VISIBLE);
        t16 = turnNumber;
        checkResults(0, 5);
    }

    final void startTic17() {
        if (turnNumber == 1) {
            binding.tic17View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic17View.setImageResource(R.drawable.player_2);

        }


        binding.tic17View.setVisibility(View.VISIBLE);
        t17 = turnNumber;
        checkResults(0, 6);
    }

    final void startTic18() {
        if (turnNumber == 1) {
            binding.tic18View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic18View.setImageResource(R.drawable.player_2);

        }


        binding.tic18View.setVisibility(View.VISIBLE);
        t18 = turnNumber;
        checkResults(0, 7);
    }

    final void startTic19() {
        if (turnNumber == 1) {
            binding.tic19View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic19View.setImageResource(R.drawable.player_2);

        }


        binding.tic19View.setVisibility(View.VISIBLE);
        t19 = turnNumber;
        checkResults(0, 8);
    }


    final void startTic21() {
        if (turnNumber == 1) {
            binding.tic21View.setImageResource(R.drawable.player_1);
        } else {
            binding.tic21View.setImageResource(R.drawable.player_2);
        }


        binding.tic21View.setVisibility(View.VISIBLE);
        t21 = turnNumber;
        checkResults(1, 0);

    } // second row

    final void startTic22() {
        if (turnNumber == 1) {
            binding.tic22View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic22View.setImageResource(R.drawable.player_2);

        }


        binding.tic22View.setVisibility(View.VISIBLE);
        t22 = turnNumber;
        checkResults(1, 1);
    }

    final void startTic23() {
        if (turnNumber == 1) {
            binding.tic23View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic23View.setImageResource(R.drawable.player_2);

        }


        binding.tic23View.setVisibility(View.VISIBLE);
        t23 = turnNumber;
        checkResults(1, 2);
    }

    final void startTic24() {
        if (turnNumber == 1) {
            binding.tic24View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic24View.setImageResource(R.drawable.player_2);

        }


        binding.tic24View.setVisibility(View.VISIBLE);
        t24 = turnNumber;
        checkResults(1, 3);
    }

    final void startTic25() {
        if (turnNumber == 1) {
            binding.tic25View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic25View.setImageResource(R.drawable.player_2);

        }


        binding.tic25View.setVisibility(View.VISIBLE);
        t25 = turnNumber;
        checkResults(1, 4);
    }

    final void startTic26() {
        if (turnNumber == 1) {
            binding.tic26View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic26View.setImageResource(R.drawable.player_2);

        }


        binding.tic26View.setVisibility(View.VISIBLE);
        t26 = turnNumber;
        checkResults(1, 5);
    }

    final void startTic27() {
        if (turnNumber == 1) {
            binding.tic27View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic27View.setImageResource(R.drawable.player_2);

        }


        binding.tic27View.setVisibility(View.VISIBLE);
        t27 = turnNumber;
        checkResults(1, 6);
    }

    final void startTic28() {
        if (turnNumber == 1) {
            binding.tic28View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic28View.setImageResource(R.drawable.player_2);

        }


        binding.tic28View.setVisibility(View.VISIBLE);
        t28 = turnNumber;
        checkResults(1, 7);
    }

    final void startTic29() {
        if (turnNumber == 1) {
            binding.tic29View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic29View.setImageResource(R.drawable.player_2);

        }


        binding.tic29View.setVisibility(View.VISIBLE);
        t29 = turnNumber;
        checkResults(1, 8);
    }

    final void startTic31() {
        if (turnNumber == 1) {
            binding.tic31View.setImageResource(R.drawable.player_1);
        } else {
            binding.tic31View.setImageResource(R.drawable.player_2);
        }


        binding.tic31View.setVisibility(View.VISIBLE);
        t31 = turnNumber;
        checkResults(2, 0);

    } // third row

    final void startTic32() {
        if (turnNumber == 1) {
            binding.tic32View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic32View.setImageResource(R.drawable.player_2);

        }


        binding.tic32View.setVisibility(View.VISIBLE);
        t32 = turnNumber;
        checkResults(2, 1);
    }

    final void startTic33() {
        if (turnNumber == 1) {
            binding.tic33View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic33View.setImageResource(R.drawable.player_2);

        }


        binding.tic33View.setVisibility(View.VISIBLE);
        t33 = turnNumber;
        checkResults(2, 2);
    }

    final void startTic34() {
        if (turnNumber == 1) {
            binding.tic34View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic34View.setImageResource(R.drawable.player_2);

        }


        binding.tic34View.setVisibility(View.VISIBLE);
        t34 = turnNumber;
        checkResults(2, 3);
    }

    final void startTic35() {
        if (turnNumber == 1) {
            binding.tic35View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic35View.setImageResource(R.drawable.player_2);

        }


        binding.tic35View.setVisibility(View.VISIBLE);
        t35 = turnNumber;
        checkResults(2, 4);
    }

    final void startTic36() {
        if (turnNumber == 1) {
            binding.tic36View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic36View.setImageResource(R.drawable.player_2);

        }


        binding.tic36View.setVisibility(View.VISIBLE);
        t36 = turnNumber;
        checkResults(2, 5);
    }

    final void startTic37() {
        if (turnNumber == 1) {
            binding.tic37View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic37View.setImageResource(R.drawable.player_2);

        }


        binding.tic37View.setVisibility(View.VISIBLE);
        t37 = turnNumber;
        checkResults(2, 6);
    }

    final void startTic38() {
        if (turnNumber == 1) {
            binding.tic38View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic38View.setImageResource(R.drawable.player_2);

        }


        binding.tic38View.setVisibility(View.VISIBLE);
        t38 = turnNumber;
        checkResults(2, 7);
    }

    final void startTic39() {
        if (turnNumber == 1) {
            binding.tic39View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic39View.setImageResource(R.drawable.player_2);

        }


        binding.tic39View.setVisibility(View.VISIBLE);
        t39 = turnNumber;
        checkResults(2, 8);
    }

    final void startTic41() {
        if (turnNumber == 1) {
            binding.tic41View.setImageResource(R.drawable.player_1);
        } else {
            binding.tic41View.setImageResource(R.drawable.player_2);
        }


        binding.tic41View.setVisibility(View.VISIBLE);
        t41 = turnNumber;
        checkResults(3, 0);

    } // 4th row

    final void startTic42() {
        if (turnNumber == 1) {
            binding.tic42View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic42View.setImageResource(R.drawable.player_2);

        }


        binding.tic42View.setVisibility(View.VISIBLE);
        t42 = turnNumber;
        checkResults(3, 1);
    }

    final void startTic43() {
        if (turnNumber == 1) {
            binding.tic43View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic43View.setImageResource(R.drawable.player_2);

        }


        binding.tic43View.setVisibility(View.VISIBLE);
        t43 = turnNumber;
        checkResults(3, 2);
    }

    final void startTic44() {
        if (turnNumber == 1) {
            binding.tic44View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic44View.setImageResource(R.drawable.player_2);

        }


        binding.tic44View.setVisibility(View.VISIBLE);
        t44 = turnNumber;
        checkResults(3, 3);
    }

    final void startTic45() {
        if (turnNumber == 1) {
            binding.tic45View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic45View.setImageResource(R.drawable.player_2);

        }


        binding.tic45View.setVisibility(View.VISIBLE);
        t45 = turnNumber;
        checkResults(3, 4);
    }

    final void startTic46() {
        if (turnNumber == 1) {
            binding.tic46View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic46View.setImageResource(R.drawable.player_2);

        }


        binding.tic46View.setVisibility(View.VISIBLE);
        t46 = turnNumber;
        checkResults(3, 5);
    }

    final void startTic47() {
        if (turnNumber == 1) {
            binding.tic47View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic47View.setImageResource(R.drawable.player_2);

        }


        binding.tic47View.setVisibility(View.VISIBLE);
        t47 = turnNumber;
        checkResults(3, 6);
    }

    final void startTic48() {
        if (turnNumber == 1) {
            binding.tic48View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic48View.setImageResource(R.drawable.player_2);

        }


        binding.tic48View.setVisibility(View.VISIBLE);
        t48 = turnNumber;
        checkResults(3, 7);
    }

    final void startTic49() {
        if (turnNumber == 1) {
            binding.tic49View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic49View.setImageResource(R.drawable.player_2);

        }


        binding.tic49View.setVisibility(View.VISIBLE);
        t49 = turnNumber;
        checkResults(3, 8);
    }

    final void startTic51() {
        if (turnNumber == 1) {
            binding.tic51View.setImageResource(R.drawable.player_1);
        } else {
            binding.tic51View.setImageResource(R.drawable.player_2);
        }


        binding.tic51View.setVisibility(View.VISIBLE);
        t51 = turnNumber;
        checkResults(4, 0);

    } // 5th row

    final void startTic52() {
        if (turnNumber == 1) {
            binding.tic52View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic52View.setImageResource(R.drawable.player_2);

        }


        binding.tic52View.setVisibility(View.VISIBLE);
        t52 = turnNumber;
        checkResults(4, 1);
    }

    final void startTic53() {
        if (turnNumber == 1) {
            binding.tic53View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic53View.setImageResource(R.drawable.player_2);

        }


        binding.tic53View.setVisibility(View.VISIBLE);
        t53 = turnNumber;
        checkResults(4, 2);
    }

    final void startTic54() {
        if (turnNumber == 1) {
            binding.tic54View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic54View.setImageResource(R.drawable.player_2);

        }


        binding.tic54View.setVisibility(View.VISIBLE);
        t54 = turnNumber;
        checkResults(4, 3);
    }

    final void startTic55() {
        if (turnNumber == 1) {
            binding.tic55View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic55View.setImageResource(R.drawable.player_2);

        }


        binding.tic55View.setVisibility(View.VISIBLE);
        t55 = turnNumber;
        checkResults(4, 4);
    }

    final void startTic56() {
        if (turnNumber == 1) {
            binding.tic56View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic56View.setImageResource(R.drawable.player_2);

        }


        binding.tic56View.setVisibility(View.VISIBLE);
        t56 = turnNumber;
        checkResults(4, 5);
    }

    final void startTic57() {
        if (turnNumber == 1) {
            binding.tic57View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic57View.setImageResource(R.drawable.player_2);

        }


        binding.tic57View.setVisibility(View.VISIBLE);
        t57 = turnNumber;
        checkResults(4, 6);
    }

    final void startTic58() {
        if (turnNumber == 1) {
            binding.tic58View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic58View.setImageResource(R.drawable.player_2);

        }


        binding.tic58View.setVisibility(View.VISIBLE);
        t58 = turnNumber;
        checkResults(4, 7);
    }

    final void startTic59() {
        if (turnNumber == 1) {
            binding.tic59View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic59View.setImageResource(R.drawable.player_2);

        }


        binding.tic59View.setVisibility(View.VISIBLE);
        t59 = turnNumber;
        checkResults(4, 8);
    }

    final void startTic61() {
        if (turnNumber == 1) {
            binding.tic61View.setImageResource(R.drawable.player_1);
        } else {
            binding.tic61View.setImageResource(R.drawable.player_2);
        }


        binding.tic61View.setVisibility(View.VISIBLE);
        t61 = turnNumber;
        checkResults(5, 0);

    } // 6th row

    final void startTic62() {
        if (turnNumber == 1) {
            binding.tic62View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic62View.setImageResource(R.drawable.player_2);

        }


        binding.tic62View.setVisibility(View.VISIBLE);
        t62 = turnNumber;
        checkResults(5, 1);
    }

    final void startTic63() {
        if (turnNumber == 1) {
            binding.tic63View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic63View.setImageResource(R.drawable.player_2);

        }


        binding.tic63View.setVisibility(View.VISIBLE);
        t63 = turnNumber;
        checkResults(5, 2);
    }

    final void startTic64() {
        if (turnNumber == 1) {
            binding.tic64View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic64View.setImageResource(R.drawable.player_2);

        }


        binding.tic64View.setVisibility(View.VISIBLE);
        t64 = turnNumber;
        checkResults(5, 3);
    }

    final void startTic65() {
        if (turnNumber == 1) {
            binding.tic65View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic65View.setImageResource(R.drawable.player_2);

        }


        binding.tic65View.setVisibility(View.VISIBLE);
        t65 = turnNumber;
        checkResults(5, 4);
    }

    final void startTic66() {
        if (turnNumber == 1) {
            binding.tic66View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic66View.setImageResource(R.drawable.player_2);

        }


        binding.tic66View.setVisibility(View.VISIBLE);
        t66 = turnNumber;
        checkResults(5, 5);
    }

    final void startTic67() {
        if (turnNumber == 1) {
            binding.tic67View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic67View.setImageResource(R.drawable.player_2);

        }


        binding.tic67View.setVisibility(View.VISIBLE);
        t67 = turnNumber;
        checkResults(5, 6);
    }

    final void startTic68() {
        if (turnNumber == 1) {
            binding.tic68View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic68View.setImageResource(R.drawable.player_2);

        }


        binding.tic68View.setVisibility(View.VISIBLE);
        t68 = turnNumber;
        checkResults(5, 7);
    }

    final void startTic69() {
        if (turnNumber == 1) {
            binding.tic69View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic69View.setImageResource(R.drawable.player_2);

        }


        binding.tic69View.setVisibility(View.VISIBLE);
        t69 = turnNumber;
        checkResults(5, 8);
    }

    final void startTic71() {
        if (turnNumber == 1) {
            binding.tic71View.setImageResource(R.drawable.player_1);
        } else {
            binding.tic71View.setImageResource(R.drawable.player_2);
        }


        binding.tic71View.setVisibility(View.VISIBLE);
        t71 = turnNumber;
        checkResults(6, 0);

    } // 7th row

    final void startTic72() {
        if (turnNumber == 1) {
            binding.tic72View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic72View.setImageResource(R.drawable.player_2);

        }


        binding.tic72View.setVisibility(View.VISIBLE);
        t72 = turnNumber;
        checkResults(6, 1);
    }

    final void startTic73() {
        if (turnNumber == 1) {
            binding.tic73View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic73View.setImageResource(R.drawable.player_2);

        }


        binding.tic73View.setVisibility(View.VISIBLE);
        t73 = turnNumber;
        checkResults(6, 2);
    }

    final void startTic74() {
        if (turnNumber == 1) {
            binding.tic74View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic74View.setImageResource(R.drawable.player_2);

        }


        binding.tic74View.setVisibility(View.VISIBLE);
        t74 = turnNumber;
        checkResults(6, 3);
    }

    final void startTic75() {
        if (turnNumber == 1) {
            binding.tic75View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic75View.setImageResource(R.drawable.player_2);

        }


        binding.tic75View.setVisibility(View.VISIBLE);
        t75 = turnNumber;
        checkResults(6, 4);
    }

    final void startTic76() {
        if (turnNumber == 1) {
            binding.tic76View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic76View.setImageResource(R.drawable.player_2);

        }


        binding.tic76View.setVisibility(View.VISIBLE);
        t76 = turnNumber;
        checkResults(6, 5);
    }

    final void startTic77() {
        if (turnNumber == 1) {
            binding.tic77View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic77View.setImageResource(R.drawable.player_2);

        }


        binding.tic77View.setVisibility(View.VISIBLE);
        t77 = turnNumber;
        checkResults(6, 6);
    }

    final void startTic78() {
        if (turnNumber == 1) {
            binding.tic78View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic78View.setImageResource(R.drawable.player_2);

        }


        binding.tic78View.setVisibility(View.VISIBLE);
        t78 = turnNumber;
        checkResults(6, 7);
    }

    final void startTic79() {
        if (turnNumber == 1) {
            binding.tic79View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic79View.setImageResource(R.drawable.player_2);

        }


        binding.tic79View.setVisibility(View.VISIBLE);
        t79 = turnNumber;
        checkResults(6, 8);
    }

    final void startTic81() {
        if (turnNumber == 1) {
            binding.tic81View.setImageResource(R.drawable.player_1);
        } else {
            binding.tic81View.setImageResource(R.drawable.player_2);
        }


        binding.tic81View.setVisibility(View.VISIBLE);
        t81 = turnNumber;
        checkResults(7, 0);

    } // 8th row

    final void startTic82() {
        if (turnNumber == 1) {
            binding.tic82View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic82View.setImageResource(R.drawable.player_2);

        }


        binding.tic82View.setVisibility(View.VISIBLE);
        t82 = turnNumber;
        checkResults(7, 1);
    }

    final void startTic83() {
        if (turnNumber == 1) {
            binding.tic83View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic83View.setImageResource(R.drawable.player_2);

        }


        binding.tic83View.setVisibility(View.VISIBLE);
        t83 = turnNumber;
        checkResults(7, 2);
    }

    final void startTic84() {
        if (turnNumber == 1) {
            binding.tic84View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic84View.setImageResource(R.drawable.player_2);

        }


        binding.tic84View.setVisibility(View.VISIBLE);
        t84 = turnNumber;
        checkResults(7, 3);
    }

    final void startTic85() {
        if (turnNumber == 1) {
            binding.tic85View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic85View.setImageResource(R.drawable.player_2);

        }


        binding.tic85View.setVisibility(View.VISIBLE);
        t85 = turnNumber;
        checkResults(7, 4);
    }

    final void startTic86() {
        if (turnNumber == 1) {
            binding.tic86View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic86View.setImageResource(R.drawable.player_2);

        }


        binding.tic86View.setVisibility(View.VISIBLE);
        t86 = turnNumber;
        checkResults(7, 5);
    }

    final void startTic87() {
        if (turnNumber == 1) {
            binding.tic87View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic87View.setImageResource(R.drawable.player_2);

        }


        binding.tic87View.setVisibility(View.VISIBLE);
        t87 = turnNumber;
        checkResults(7, 6);
    }

    final void startTic88() {
        if (turnNumber == 1) {
            binding.tic88View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic88View.setImageResource(R.drawable.player_2);

        }


        binding.tic88View.setVisibility(View.VISIBLE);
        t88 = turnNumber;
        checkResults(7, 7);
    }

    final void startTic89() {
        if (turnNumber == 1) {
            binding.tic89View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic89View.setImageResource(R.drawable.player_2);

        }


        binding.tic89View.setVisibility(View.VISIBLE);
        t89 = turnNumber;
        checkResults(7, 8);
    }

    final void startTic91() {
        if (turnNumber == 1) {
            binding.tic91View.setImageResource(R.drawable.player_1);
        } else {
            binding.tic91View.setImageResource(R.drawable.player_2);
        }


        binding.tic91View.setVisibility(View.VISIBLE);
        t91 = turnNumber;
        checkResults(8, 0);

    } // 9th row

    final void startTic92() {
        if (turnNumber == 1) {
            binding.tic92View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic92View.setImageResource(R.drawable.player_2);

        }


        binding.tic92View.setVisibility(View.VISIBLE);
        t92 = turnNumber;
        checkResults(8, 1);
    }

    final void startTic93() {
        if (turnNumber == 1) {
            binding.tic93View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic93View.setImageResource(R.drawable.player_2);

        }


        binding.tic93View.setVisibility(View.VISIBLE);
        t93 = turnNumber;
        checkResults(8, 2);
    }

    final void startTic94() {
        if (turnNumber == 1) {
            binding.tic94View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic94View.setImageResource(R.drawable.player_2);

        }


        binding.tic94View.setVisibility(View.VISIBLE);
        t94 = turnNumber;
        checkResults(8, 3);
    }

    final void startTic95() {
        if (turnNumber == 1) {
            binding.tic95View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic95View.setImageResource(R.drawable.player_2);

        }


        binding.tic95View.setVisibility(View.VISIBLE);
        t95 = turnNumber;
        checkResults(8, 4);
    }

    final void startTic96() {
        if (turnNumber == 1) {
            binding.tic96View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic96View.setImageResource(R.drawable.player_2);

        }


        binding.tic96View.setVisibility(View.VISIBLE);
        t96 = turnNumber;
        checkResults(8, 5);
    }

    final void startTic97() {
        if (turnNumber == 1) {
            binding.tic97View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic97View.setImageResource(R.drawable.player_2);

        }


        binding.tic97View.setVisibility(View.VISIBLE);
        t97 = turnNumber;
        checkResults(8, 6);
    }

    final void startTic98() {
        if (turnNumber == 1) {
            binding.tic98View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic98View.setImageResource(R.drawable.player_2);

        }


        binding.tic98View.setVisibility(View.VISIBLE);
        t98 = turnNumber;
        checkResults(8, 7);
    }

    final void startTic99() {
        if (turnNumber == 1) {
            binding.tic99View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic99View.setImageResource(R.drawable.player_2);

        }


        binding.tic99View.setVisibility(View.VISIBLE);
        t99 = turnNumber;
        checkResults(8, 8);
    }

    final void startTic101() {
        if (turnNumber == 1) {
            binding.tic101View.setImageResource(R.drawable.player_1);
        } else {
            binding.tic101View.setImageResource(R.drawable.player_2);
        }


        binding.tic101View.setVisibility(View.VISIBLE);
        t101 = turnNumber;
        checkResults(9, 0);

    } // 10th row

    final void startTic102() {
        if (turnNumber == 1) {
            binding.tic102View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic102View.setImageResource(R.drawable.player_2);

        }


        binding.tic102View.setVisibility(View.VISIBLE);
        t102 = turnNumber;
        checkResults(9, 1);
    }

    final void startTic103() {
        if (turnNumber == 1) {
            binding.tic103View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic103View.setImageResource(R.drawable.player_2);

        }


        binding.tic103View.setVisibility(View.VISIBLE);
        t103 = turnNumber;
        checkResults(9, 2);
    }

    final void startTic104() {
        if (turnNumber == 1) {
            binding.tic104View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic104View.setImageResource(R.drawable.player_2);

        }


        binding.tic104View.setVisibility(View.VISIBLE);
        t104 = turnNumber;
        checkResults(9, 3);
    }

    final void startTic105() {
        if (turnNumber == 1) {
            binding.tic105View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic105View.setImageResource(R.drawable.player_2);

        }


        binding.tic105View.setVisibility(View.VISIBLE);
        t105 = turnNumber;
        checkResults(9, 4);
    }

    final void startTic106() {
        if (turnNumber == 1) {
            binding.tic106View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic106View.setImageResource(R.drawable.player_2);

        }


        binding.tic106View.setVisibility(View.VISIBLE);
        t106 = turnNumber;
        checkResults(9, 5);
    }

    final void startTic107() {
        if (turnNumber == 1) {
            binding.tic107View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic107View.setImageResource(R.drawable.player_2);

        }


        binding.tic107View.setVisibility(View.VISIBLE);
        t107 = turnNumber;
        checkResults(9, 6);
    }

    final void startTic108() {
        if (turnNumber == 1) {
            binding.tic108View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic108View.setImageResource(R.drawable.player_2);

        }


        binding.tic108View.setVisibility(View.VISIBLE);
        t108 = turnNumber;
        checkResults(9, 7);
    }

    final void startTic109() {
        if (turnNumber == 1) {
            binding.tic109View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic109View.setImageResource(R.drawable.player_2);

        }


        binding.tic109View.setVisibility(View.VISIBLE);
        t109 = turnNumber;
        checkResults(9, 8);
    }

    final void startTic111() {
        if (turnNumber == 1) {
            binding.tic111View.setImageResource(R.drawable.player_1);
        } else {
            binding.tic111View.setImageResource(R.drawable.player_2);
        }


        binding.tic111View.setVisibility(View.VISIBLE);
        t111 = turnNumber;
        checkResults(10, 0);

    } // 11th row

    final void startTic112() {
        if (turnNumber == 1) {
            binding.tic112View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic112View.setImageResource(R.drawable.player_2);

        }


        binding.tic112View.setVisibility(View.VISIBLE);
        t112 = turnNumber;
        checkResults(10, 1);
    }

    final void startTic113() {
        if (turnNumber == 1) {
            binding.tic113View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic113View.setImageResource(R.drawable.player_2);

        }


        binding.tic113View.setVisibility(View.VISIBLE);
        t113 = turnNumber;
        checkResults(10, 2);
    }

    final void startTic114() {
        if (turnNumber == 1) {
            binding.tic114View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic114View.setImageResource(R.drawable.player_2);

        }


        binding.tic114View.setVisibility(View.VISIBLE);
        t114 = turnNumber;
        checkResults(10, 3);
    }

    final void startTic115() {
        if (turnNumber == 1) {
            binding.tic115View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic115View.setImageResource(R.drawable.player_2);

        }


        binding.tic115View.setVisibility(View.VISIBLE);
        t115 = turnNumber;
        checkResults(10, 4);
    }

    final void startTic116() {
        if (turnNumber == 1) {
            binding.tic116View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic116View.setImageResource(R.drawable.player_2);

        }


        binding.tic116View.setVisibility(View.VISIBLE);
        t116 = turnNumber;
        checkResults(10, 5);
    }

    final void startTic117() {
        if (turnNumber == 1) {
            binding.tic117View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic117View.setImageResource(R.drawable.player_2);

        }


        binding.tic117View.setVisibility(View.VISIBLE);
        t117 = turnNumber;
        checkResults(10, 6);
    }

    final void startTic118() {
        if (turnNumber == 1) {
            binding.tic118View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic118View.setImageResource(R.drawable.player_2);

        }


        binding.tic118View.setVisibility(View.VISIBLE);
        t118 = turnNumber;
        checkResults(10, 7);
    }

    final void startTic119() {
        if (turnNumber == 1) {
            binding.tic119View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic119View.setImageResource(R.drawable.player_2);

        }


        binding.tic119View.setVisibility(View.VISIBLE);
        t119 = turnNumber;
        checkResults(10, 8);
    }

    final void startTic121() {
        if (turnNumber == 1) {
            binding.tic121View.setImageResource(R.drawable.player_1);
        } else {
            binding.tic121View.setImageResource(R.drawable.player_2);
        }


        binding.tic121View.setVisibility(View.VISIBLE);
        t121 = turnNumber;
        checkResults(11, 0);

    } // 12th row

    final void startTic122() {
        if (turnNumber == 1) {
            binding.tic122View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic122View.setImageResource(R.drawable.player_2);

        }


        binding.tic122View.setVisibility(View.VISIBLE);
        t122 = turnNumber;
        checkResults(11, 1);
    }

    final void startTic123() {
        if (turnNumber == 1) {
            binding.tic123View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic123View.setImageResource(R.drawable.player_2);

        }


        binding.tic123View.setVisibility(View.VISIBLE);
        t123 = turnNumber;
        checkResults(11, 2);
    }

    final void startTic124() {
        if (turnNumber == 1) {
            binding.tic124View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic124View.setImageResource(R.drawable.player_2);

        }


        binding.tic124View.setVisibility(View.VISIBLE);
        t124 = turnNumber;
        checkResults(11, 3);
    }

    final void startTic125() {
        if (turnNumber == 1) {
            binding.tic125View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic125View.setImageResource(R.drawable.player_2);

        }


        binding.tic125View.setVisibility(View.VISIBLE);
        t125 = turnNumber;
        checkResults(11, 4);
    }

    final void startTic126() {
        if (turnNumber == 1) {
            binding.tic126View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic126View.setImageResource(R.drawable.player_2);

        }


        binding.tic126View.setVisibility(View.VISIBLE);
        t126 = turnNumber;
        checkResults(11, 5);
    }

    final void startTic127() {
        if (turnNumber == 1) {
            binding.tic127View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic127View.setImageResource(R.drawable.player_2);

        }


        binding.tic127View.setVisibility(View.VISIBLE);
        t127 = turnNumber;
        checkResults(11, 6);
    }

    final void startTic128() {
        if (turnNumber == 1) {
            binding.tic128View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic128View.setImageResource(R.drawable.player_2);

        }


        binding.tic128View.setVisibility(View.VISIBLE);
        t128 = turnNumber;
        checkResults(11, 7);
    }

    final void startTic129() {
        if (turnNumber == 1) {
            binding.tic129View.setImageResource(R.drawable.player_1);

        } else {
            binding.tic129View.setImageResource(R.drawable.player_2);

        }


        binding.tic129View.setVisibility(View.VISIBLE);
        t129 = turnNumber;
        checkResults(11, 8);
    }


    final void checkResults(int row, int column) {
        if (sounds) {
            playSound();
        }
        checkWinStatus(row, column);
    }


    final void checkWinStatus(int row, int column) {

        turnChanger = true;
        boolean matched;
        int r1 = 0, r2 = 0, r3 = 0;
        int c1 = 0, c2 = 0, c3 = 0;


        int[][] matrix = {
                {t11, t12, t13, t14, t15, t16, t17, t18, t19},
                {t21, t22, t23, t24, t25, t26, t27, t28, t29},
                {t31, t32, t33, t34, t35, t36, t37, t38, t39},
                {t41, t42, t43, t44, t45, t46, t47, t48, t49},
                {t51, t52, t53, t54, t55, t56, t57, t58, t59},
                {t61, t62, t63, t64, t65, t66, t67, t68, t69},
                {t71, t72, t73, t74, t75, t76, t77, t78, t79},
                {t81, t82, t83, t84, t85, t86, t87, t88, t89},
                {t91, t92, t93, t94, t95, t96, t97, t98, t99},
                {t101, t102, t103, t104, t105, t106, t107, t108, t109},
                {t111, t112, t113, t114, t115, t116, t117, t118, t119},
                {t121, t122, t123, t124, t125, t126, t127, t128, t129}
        };


        for (int i = 1; i <= 8; i++) { // checking from the center of selected box

            switch (i) {
                case 1:
                    r1 = r2 = r3 = row; // rows are equal

                    c1 = column; // columns will change
                    c2 = c1 - 1;
                    c3 = c2 - 1;
                    break;
                case 2:
                    r1 = row; // rows and columns will change
                    r2 = r1 - 1;
                    r3 = r2 - 1;

                    c1 = column;
                    c2 = c1 - 1;
                    c3 = c2 - 1;
                    break;
                case 3:
                    r1 = row; // row will change
                    r2 = r1 - 1;
                    r3 = r2 - 1;

                    c1 = c2 = c3 = column; // column is constant;
                    break;
                case 4:
                    r1 = row; // rows and columns will change
                    r2 = r1 - 1;
                    r3 = r2 - 1;

                    c1 = column;
                    c2 = c1 + 1;
                    c3 = c2 + 1;
                    break;
                case 5:
                    r1 = r2 = r3 = row; // rows are equal

                    c1 = column; // columns will change
                    c2 = c1 + 1;
                    c3 = c2 + 1;
                    break;
                case 6:
                    r1 = row; // rows and columns will change
                    r2 = r1 + 1;
                    r3 = r2 + 1;

                    c1 = column;
                    c2 = c1 + 1;
                    c3 = c2 + 1;
                    break;
                case 7:

                    r1 = row; // row will change
                    r2 = r1 + 1;
                    r3 = r2 + 1;

                    c1 = c2 = c3 = column; // column is constant;
                    break;
                case 8:
                    r1 = row; // rows and columns will change
                    r2 = r1 + 1;
                    r3 = r2 + 1;

                    c1 = column;
                    c2 = c1 - 1;
                    c3 = c2 - 1;
                    break;
            }

            // checking whether they are matched or not or not.

            try {
//                && (matrix[r1][c1] != -1 && matrix[r2][c2] != -1 && matrix[r3][c3] != -1)
                matched = (matrix[r1][c1] != 0 && matrix[r2][c2] != 0 && matrix[r3][c3] != 0) && (matrix[r1][c1] == matrix[r2][c2] && matrix[r2][c2] == matrix[r3][c3]);// ((matrix[r1][c1] != -1 && matrix[r2][c2] != -1) || (matrix[r2][c2] != -1 && matrix[r3][c3] != -1) || (matrix[r1][c1] != -1 && matrix[r3][c3] != -1));

                boolean matched2 = (matrix[r1][c1] != 0 && matrix[r2][c2] != 0 && matrix[r3][c3] != 0) && ((matrix[r1][c1] != -(turnNumber) && matrix[r2][c2] != -(turnNumber)) || (matrix[r2][c2] != -(turnNumber) && matrix[r3][c3] != -(turnNumber)) || (matrix[r1][c1] != -(turnNumber) && matrix[r3][c3] != -(turnNumber))) && (matrix[r1][c1] > 0 || matrix[r2][c2] > 0 || matrix[r3][c3] > 0) && (matrix[r1][c1] == matrix[r2][c2] || matrix[r2][c2] == matrix[r3][c3] || matrix[r1][c1] == matrix[r3][c3]);
                boolean matched3 = matrixViews[r1][c1].getDrawable().getConstantState() == matrixViews[r2][c2].getDrawable().getConstantState() && matrixViews[r1][c1].getDrawable().getConstantState() == matrixViews[r3][c3].getDrawable().getConstantState();
                matched = matched || (matched2 && matched3);
            } catch (Exception e) {
                continue;
            }

            if (matched) {
                changeNumbers(r1, c1, r2, c2, r3, c3);
                changeBackground(r1, c1, r2, c2, r3, c3);
                addScore();
            }


        } // checking from center of the selected box


        r1 = r2 = r3 = c1 = c2 = c3 = 0;

        for (int i = 1; i <= 4; i++) {

            switch (i) {
                case 1:
                    r1 = r2 = r3 = row; // rows are equal

                    c1 = column; // columns will change
                    c2 = column - 1;
                    c3 = column + 1;
                    break;
                case 2:
                    r1 = row; // rows and columns will change
                    r2 = row - 1;
                    r3 = row + 1;

                    c1 = column;
                    c2 = column - 1;
                    c3 = column + 1;
                    break;
                case 3:
                    r1 = row; // rows and columns will change
                    r2 = row - 1;
                    r3 = row + 1;

                    c1 = c2 = c3 = column; // column is constant;
                    break;
                case 4:
                    r1 = row; // rows and columns will change
                    r2 = row - 1;
                    r3 = row + 1;

                    c1 = column;
                    c2 = column + 1;
                    c3 = column - 1;
                    break;

            }

            try {
                matched = (matrix[r1][c1] != 0 && matrix[r2][c2] != 0 && matrix[r3][c3] != 0) && (matrix[r1][c1] == matrix[r2][c2] && matrix[r2][c2] == matrix[r3][c3]);

                boolean matched2 = (matrix[r1][c1] != 0 && matrix[r2][c2] != 0 && matrix[r3][c3] != 0) && (matrix[r1][c1] > 0 || matrix[r2][c2] > 0 || matrix[r3][c3] > 0);// ((matrix[r1][c1] != -1 && matrix[r2][c2] != -1) || (matrix[r2][c2] != -1 && matrix[r3][c3] != -1) || (matrix[r1][c1] != -1 && matrix[r3][c3] != -1)) && (matrix[r1][c1] > 0 || matrix[r2][c2] > 0 || matrix[r3][c3] > 0) && (matrix[r1][c1] == matrix[r2][c2] || matrix[r2][c2] == matrix[r3][c3] || matrix[r1][c1] == matrix[r3][c3]);
                boolean matched3 = matrixViews[r1][c1].getDrawable().getConstantState() == matrixViews[r2][c2].getDrawable().getConstantState() && matrixViews[r1][c1].getDrawable().getConstantState() == matrixViews[r3][c3].getDrawable().getConstantState();
                matched = matched || (matched2 && matched3);
//                matched = matched || matched2;
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            if (matched) {
                changeNumbers(r1, c1, r2, c2, r3, c3);
                changeBackground(r1, c1, r2, c2, r3, c3);

                addScore();
            }

        }

        // 4 points check

        int r4 = 0, c4 = 0;
        r1 = r2 = r3 = c1 = c2 = c3 = 0;


        for (int i = 1; i <= 8; i++) { // checking from the center of selected box

            switch (i) {
                case 1:
                    r1 = r2 = r3 = r4 = row; // rows are equal

                    c1 = column; // columns will change
                    c2 = c1 - 1;
                    c3 = c2 - 1;
                    c4 = c3 - 1;
                    break;
                case 2:
                    r1 = row; // rows and columns will change
                    r2 = r1 - 1;
                    r3 = r2 - 1;
                    r4 = r3 - 1;

                    c1 = column;
                    c2 = c1 - 1;
                    c3 = c2 - 1;
                    c4 = c3 - 1;
                    break;
                case 3:
                    r1 = row; // row will change
                    r2 = r1 - 1;
                    r3 = r2 - 1;
                    r4 = r3 - 1;

                    c1 = c2 = c3 = c4 = column; // column is constant;
                    break;
                case 4:
                    r1 = row; // rows and columns will change
                    r2 = r1 - 1;
                    r3 = r2 - 1;
                    r4 = r3 - 1;

                    c1 = column;
                    c2 = c1 + 1;
                    c3 = c2 + 1;
                    c4 = c3 + 1;
                    break;
                case 5:
                    r1 = r2 = r3 = r4 = row; // rows are equal

                    c1 = column; // columns will change
                    c2 = c1 + 1;
                    c3 = c2 + 1;
                    c4 = c3 + 1;
                    break;
                case 6:
                    r1 = row; // rows and columns will change
                    r2 = r1 + 1;
                    r3 = r2 + 1;
                    r4 = r3 + 1;

                    c1 = column;
                    c2 = c1 + 1;
                    c3 = c2 + 1;
                    c4 = c3 + 1;
                    break;
                case 7:

                    r1 = row; // row will change
                    r2 = r1 + 1;
                    r3 = r2 + 1;
                    r4 = r3 + 1;

                    c1 = c2 = c3 = c4 = column; // column is constant;
                    break;
                case 8:
                    r1 = row; // rows and columns will change
                    r2 = r1 + 1;
                    r3 = r2 + 1;
                    r4 = r3 + 1;

                    c1 = column;
                    c2 = c1 - 1;
                    c3 = c2 - 1;
                    c4 = c3 - 1;
                    break;
            }

            // checking whether they are matched or not or not.

            try {
//                && (matrix[r1][c1] != -1 && matrix[r2][c2] != -1 && matrix[r3][c3] != -1)
//                matched = (matrix[r1][c1] != 0 && matrix[r2][c2] != 0 && matrix[r3][c3] != 0) && (matrix[r1][c1] == matrix[r2][c2] && matrix[r2][c2] == matrix[r3][c3]); ((matrix[r1][c1] != -1 && matrix[r2][c2] != -1) || (matrix[r2][c2] != -1 && matrix[r3][c3] != -1) || (matrix[r1][c1] != -1 && matrix[r3][c3] != -1));

                boolean matched2 = (matrix[r1][c1] != 0 && matrix[r2][c2] != 0 && matrix[r3][c3] != 0) && (matrix[r1][c1] > 0 || matrix[r2][c2] > 0 || matrix[r3][c3] > 0) && ((matrix[r1][c1] == -(turnNumber) && matrix[r2][c2] == -(turnNumber)) || (matrix[r2][c2] == -(turnNumber) && matrix[r3][c3] == -(turnNumber)) || (matrix[r1][c1] == -(turnNumber) && matrix[r3][c3] == -(turnNumber)));// && (matrix[r1][c1] == matrix[r2][c2] || matrix[r2][c2] == matrix[r3][c3] || matrix[r1][c1] == matrix[r3][c3]);
//                boolean matched3 = matrixViews[r1][c1].getDrawable().getConstantState() == matrixViews[r2][c2].getDrawable().getConstantState() && matrixViews[r1][c1].getDrawable().getConstantState() == matrixViews[r3][c3].getDrawable().getConstantState();
                matched = matched2 && (matrix[r4][c4] == 0 || matrix[r4][c4] != (-turnNumber));
            } catch (Exception e) {
                continue;
            }

            if (matched) {
                changeNumbers(r1, c1, r2, c2, r3, c3);
                changeBackground(r1, c1, r2, c2, r3, c3);
                addScore();
            }


        } // checking from center of the selected box


        if (!checkGameStatus(matrix)) {
            if (turnChanger) {
                changeTurn();
                oneMoreChance(false);
            } else {

                Toast.makeText(getContext(), "You got one more chance", Toast.LENGTH_LONG).show();

                oneMoreChance(true);
            }
        } else {
            Toast.makeText(getContext(), "Game over", Toast.LENGTH_SHORT).show();
            showWinnerPoster();
        }
    }


    final void changeNumbers(int r1, int c1, int r2, int c2, int r3, int c3) { // to reserve the boxes

        int[][] boxNumbers = {{11, 12, 13, 14, 15, 16, 17, 18, 19},
                {21, 22, 23, 24, 25, 26, 27, 28, 29},
                {31, 32, 33, 34, 35, 36, 37, 38, 39},
                {41, 42, 43, 44, 45, 46, 47, 48, 49},
                {51, 52, 53, 54, 55, 56, 57, 58, 59},
                {61, 62, 63, 64, 65, 66, 67, 68, 69},
                {71, 72, 73, 74, 75, 76, 77, 78, 79},
                {81, 82, 83, 84, 85, 86, 87, 88, 89},
                {91, 92, 93, 94, 95, 96, 97, 98, 99},
                {101, 102, 103, 104, 105, 106, 107, 108, 109},
                {111, 112, 113, 114, 115, 116, 117, 118, 119},
                {121, 122, 123, 124, 125, 126, 127, 128, 129},


        };

        switch (boxNumbers[r1][c1]) {
            case 11:
                if (turnNumber == 1) {
                    t11 = -1;
                } else if (turnNumber == 2) {
                    t11 = -2;
                }
                break;
            case 12:
                if (turnNumber == 1) {
                    t12 = -1;
                } else if (turnNumber == 2) {
                    t12 = -2;
                }
                break;
            case 13:
                if (turnNumber == 1) {
                    t13 = -1;
                } else if (turnNumber == 2) {
                    t13 = -2;
                }

                break;
            case 14:
                if (turnNumber == 1) {
                    t14 = -1;
                } else if (turnNumber == 2) {
                    t14 = -2;
                }
                break;
            case 15:
                if (turnNumber == 1) {
                    t15 = -1;
                } else if (turnNumber == 2) {
                    t15 = -2;
                }
                break;
            case 16:
                if (turnNumber == 1) {
                    t16 = -1;
                } else if (turnNumber == 2) {
                    t16 = -2;
                }
                break;
            case 17:
                if (turnNumber == 1) {
                    t17 = -1;
                } else if (turnNumber == 2) {
                    t17 = -2;
                }
                break;
            case 18:
                if (turnNumber == 1) {
                    t18 = -1;
                } else if (turnNumber == 2) {
                    t18 = -2;
                }
                break;
            case 19:
                if (turnNumber == 1) {
                    t19 = -1;
                } else if (turnNumber == 2) {
                    t19 = -2;
                }
                break;          // row 1 completed

            case 21:            // row 2
                if (turnNumber == 1) {
                    t21 = -1;
                } else if (turnNumber == 2) {
                    t21 = -2;
                }
                break;
            case 22:
                if (turnNumber == 1) {
                    t22 = -1;
                } else if (turnNumber == 2) {
                    t22 = -2;
                }
                break;
            case 23:
                if (turnNumber == 1) {
                    t23 = -1;
                } else if (turnNumber == 2) {
                    t23 = -2;
                }
                break;
            case 24:
                if (turnNumber == 1) {
                    t24 = -1;
                } else if (turnNumber == 2) {
                    t24 = -2;
                }
                break;
            case 25:
                if (turnNumber == 1) {
                    t25 = -1;
                } else if (turnNumber == 2) {
                    t25 = -2;
                }
                break;
            case 26:
                if (turnNumber == 1) {
                    t26 = -1;
                } else if (turnNumber == 2) {
                    t26 = -2;
                }
                break;
            case 27:
                if (turnNumber == 1) {
                    t27 = -1;
                } else if (turnNumber == 2) {
                    t27 = -2;
                }
                break;
            case 28:
                if (turnNumber == 1) {
                    t28 = -1;
                } else if (turnNumber == 2) {
                    t28 = -2;
                }
                break;
            case 29:
                if (turnNumber == 1) {
                    t29 = -1;
                } else if (turnNumber == 2) {
                    t29 = -2;
                }
                break;          // row 2 completed

            case 31:            // row 3
                if (turnNumber == 1) {
                    t31 = -1;
                } else if (turnNumber == 2) {
                    t31 = -2;
                }
                break;
            case 32:
                if (turnNumber == 1) {
                    t32 = -1;
                } else if (turnNumber == 2) {
                    t32 = -2;
                }
                break;
            case 33:
                if (turnNumber == 1) {
                    t33 = -1;
                } else if (turnNumber == 2) {
                    t33 = -2;
                }
                break;
            case 34:
                if (turnNumber == 1) {
                    t34 = -1;
                } else if (turnNumber == 2) {
                    t34 = -2;
                }
                break;
            case 35:
                if (turnNumber == 1) {
                    t35 = -1;
                } else if (turnNumber == 2) {
                    t35 = -2;
                }
                break;
            case 36:
                if (turnNumber == 1) {
                    t36 = -1;
                } else if (turnNumber == 2) {
                    t36 = -2;
                }
                break;
            case 37:
                if (turnNumber == 1) {
                    t37 = -1;
                } else if (turnNumber == 2) {
                    t37 = -2;
                }
                break;
            case 38:
                if (turnNumber == 1) {
                    t38 = -1;
                } else if (turnNumber == 2) {
                    t38 = -2;
                }
                break;
            case 39:
                if (turnNumber == 1) {
                    t39 = -1;
                } else if (turnNumber == 2) {
                    t39 = -2;
                }
                break;          // row 3 completed

            case 41:            // row 4
                if (turnNumber == 1) {
                    t41 = -1;
                } else if (turnNumber == 2) {
                    t41 = -2;
                }
                break;
            case 42:
                if (turnNumber == 1) {
                    t42 = -1;
                } else if (turnNumber == 2) {
                    t42 = -2;
                }
                break;
            case 43:
                if (turnNumber == 1) {
                    t43 = -1;
                } else if (turnNumber == 2) {
                    t43 = -2;
                }
                break;
            case 44:
                if (turnNumber == 1) {
                    t44 = -1;
                } else if (turnNumber == 2) {
                    t44 = -2;
                }
                break;
            case 45:
                if (turnNumber == 1) {
                    t45 = -1;
                } else if (turnNumber == 2) {
                    t45 = -2;
                }
                break;
            case 46:
                if (turnNumber == 1) {
                    t46 = -1;
                } else if (turnNumber == 2) {
                    t46 = -2;
                }
                break;
            case 47:
                if (turnNumber == 1) {
                    t47 = -1;
                } else if (turnNumber == 2) {
                    t47 = -2;
                }
                break;
            case 48:
                if (turnNumber == 1) {
                    t48 = -1;
                } else if (turnNumber == 2) {
                    t48 = -2;
                }
                break;
            case 49:
                if (turnNumber == 1) {
                    t49 = -1;
                } else if (turnNumber == 2) {
                    t49 = -2;
                }
                break;          // row 4 completed

            case 51:            // row 5
                if (turnNumber == 1) {
                    t51 = -1;
                } else if (turnNumber == 2) {
                    t51 = -2;
                }
                break;
            case 52:
                if (turnNumber == 1) {
                    t52 = -1;
                } else if (turnNumber == 2) {
                    t52 = -2;
                }
                break;
            case 53:
                if (turnNumber == 1) {
                    t53 = -1;
                } else if (turnNumber == 2) {
                    t53 = -2;
                }
                break;
            case 54:
                if (turnNumber == 1) {
                    t54 = -1;
                } else if (turnNumber == 2) {
                    t54 = -2;
                }
                break;
            case 55:
                if (turnNumber == 1) {
                    t55 = -1;
                } else if (turnNumber == 2) {
                    t55 = -2;
                }
                break;
            case 56:
                if (turnNumber == 1) {
                    t56 = -1;
                } else if (turnNumber == 2) {
                    t56 = -2;
                }
                break;
            case 57:
                if (turnNumber == 1) {
                    t57 = -1;
                } else if (turnNumber == 2) {
                    t57 = -2;
                }
                break;
            case 58:
                if (turnNumber == 1) {
                    t58 = -1;
                } else if (turnNumber == 2) {
                    t58 = -2;
                }
                break;
            case 59:
                if (turnNumber == 1) {
                    t59 = -1;
                } else if (turnNumber == 2) {
                    t59 = -2;
                }
                break;          // row 5 completed

            case 61:            // row 6
                if (turnNumber == 1) {
                    t61 = -1;
                } else if (turnNumber == 2) {
                    t61 = -2;
                }
                break;
            case 62:
                if (turnNumber == 1) {
                    t62 = -1;
                } else if (turnNumber == 2) {
                    t62 = -2;
                }
                break;
            case 63:
                if (turnNumber == 1) {
                    t63 = -1;
                } else if (turnNumber == 2) {
                    t63 = -2;
                }
                break;
            case 64:
                if (turnNumber == 1) {
                    t64 = -1;
                } else if (turnNumber == 2) {
                    t64 = -2;
                }
                break;
            case 65:
                if (turnNumber == 1) {
                    t65 = -1;
                } else if (turnNumber == 2) {
                    t65 = -2;
                }
                break;
            case 66:
                if (turnNumber == 1) {
                    t66 = -1;
                } else if (turnNumber == 2) {
                    t66 = -2;
                }
                break;
            case 67:
                if (turnNumber == 1) {
                    t67 = -1;
                } else if (turnNumber == 2) {
                    t67 = -2;
                }
                break;
            case 68:
                if (turnNumber == 1) {
                    t68 = -1;
                } else if (turnNumber == 2) {
                    t68 = -2;
                }
                break;
            case 69:
                if (turnNumber == 1) {
                    t69 = -1;
                } else if (turnNumber == 2) {
                    t69 = -2;
                }
                break;          // row 6 completed

            case 71:            // row 7
                if (turnNumber == 1) {
                    t71 = -1;
                } else if (turnNumber == 2) {
                    t71 = -2;
                }
                break;
            case 72:
                if (turnNumber == 1) {
                    t72 = -1;
                } else if (turnNumber == 2) {
                    t72 = -2;
                }
                break;
            case 73:
                if (turnNumber == 1) {
                    t73 = -1;
                } else if (turnNumber == 2) {
                    t73 = -2;
                }
                break;
            case 74:
                if (turnNumber == 1) {
                    t74 = -1;
                } else if (turnNumber == 2) {
                    t74 = -2;
                }
                break;
            case 75:
                if (turnNumber == 1) {
                    t75 = -1;
                } else if (turnNumber == 2) {
                    t75 = -2;
                }
                break;
            case 76:
                if (turnNumber == 1) {
                    t76 = -1;
                } else if (turnNumber == 2) {
                    t76 = -2;
                }
                break;
            case 77:
                if (turnNumber == 1) {
                    t77 = -1;
                } else if (turnNumber == 2) {
                    t77 = -2;
                }
                break;
            case 78:
                if (turnNumber == 1) {
                    t78 = -1;
                } else if (turnNumber == 2) {
                    t78 = -2;
                }
                break;
            case 79:
                if (turnNumber == 1) {
                    t79 = -1;
                } else if (turnNumber == 2) {
                    t79 = -2;
                }
                break;          // row 7 completed

            case 81:            // row 8
                if (turnNumber == 1) {
                    t81 = -1;
                } else if (turnNumber == 2) {
                    t81 = -2;
                }
                break;
            case 82:
                if (turnNumber == 1) {
                    t82 = -1;
                } else if (turnNumber == 2) {
                    t82 = -2;
                }
                break;
            case 83:
                if (turnNumber == 1) {
                    t83 = -1;
                } else if (turnNumber == 2) {
                    t83 = -2;
                }
                break;
            case 84:
                if (turnNumber == 1) {
                    t84 = -1;
                } else if (turnNumber == 2) {
                    t84 = -2;
                }
                break;
            case 85:
                if (turnNumber == 1) {
                    t85 = -1;
                } else if (turnNumber == 2) {
                    t85 = -2;
                }
                break;
            case 86:
                if (turnNumber == 1) {
                    t86 = -1;
                } else if (turnNumber == 2) {
                    t86 = -2;
                }
                break;
            case 87:
                if (turnNumber == 1) {
                    t87 = -1;
                } else if (turnNumber == 2) {
                    t87 = -2;
                }
                break;
            case 88:
                if (turnNumber == 1) {
                    t88 = -1;
                } else if (turnNumber == 2) {
                    t88 = -2;
                }
                break;
            case 89:
                if (turnNumber == 1) {
                    t89 = -1;
                } else if (turnNumber == 2) {
                    t89 = -2;
                }
                break;          // row 8 completed

            case 91:            // row 9
                if (turnNumber == 1) {
                    t91 = -1;
                } else if (turnNumber == 2) {
                    t91 = -2;
                }
                break;
            case 92:
                if (turnNumber == 1) {
                    t92 = -1;
                } else if (turnNumber == 2) {
                    t92 = -2;
                }
                break;
            case 93:
                if (turnNumber == 1) {
                    t93 = -1;
                } else if (turnNumber == 2) {
                    t93 = -2;
                }
                break;
            case 94:
                if (turnNumber == 1) {
                    t94 = -1;
                } else if (turnNumber == 2) {
                    t94 = -2;
                }
                break;
            case 95:
                if (turnNumber == 1) {
                    t95 = -1;
                } else if (turnNumber == 2) {
                    t95 = -2;
                }
                break;
            case 96:
                if (turnNumber == 1) {
                    t96 = -1;
                } else if (turnNumber == 2) {
                    t96 = -2;
                }
                break;
            case 97:
                if (turnNumber == 1) {
                    t97 = -1;
                } else if (turnNumber == 2) {
                    t97 = -2;
                }
                break;
            case 98:
                if (turnNumber == 1) {
                    t98 = -1;
                } else if (turnNumber == 2) {
                    t98 = -2;
                }
                break;
            case 99:
                if (turnNumber == 1) {
                    t99 = -1;
                } else if (turnNumber == 2) {
                    t99 = -2;
                }
                break;          // row 9 completed

            case 101:            // row 10
                if (turnNumber == 1) {
                    t101 = -1;
                } else if (turnNumber == 2) {
                    t101 = -2;
                }
                break;
            case 102:
                if (turnNumber == 1) {
                    t102 = -1;
                } else if (turnNumber == 2) {
                    t102 = -2;
                }
                break;
            case 103:
                if (turnNumber == 1) {
                    t103 = -1;
                } else if (turnNumber == 2) {
                    t103 = -2;
                }
                break;
            case 104:
                if (turnNumber == 1) {
                    t104 = -1;
                } else if (turnNumber == 2) {
                    t104 = -2;
                }
                break;
            case 105:
                if (turnNumber == 1) {
                    t105 = -1;
                } else if (turnNumber == 2) {
                    t105 = -2;
                }
                break;
            case 106:
                if (turnNumber == 1) {
                    t106 = -1;
                } else if (turnNumber == 2) {
                    t106 = -2;
                }
                break;
            case 107:
                if (turnNumber == 1) {
                    t107 = -1;
                } else if (turnNumber == 2) {
                    t107 = -2;
                }
                break;
            case 108:
                if (turnNumber == 1) {
                    t108 = -1;
                } else if (turnNumber == 2) {
                    t108 = -2;
                }
                break;
            case 109:
                if (turnNumber == 1) {
                    t109 = -1;
                } else if (turnNumber == 2) {
                    t109 = -2;
                }
                break;          // row 10 completed

            case 111:            // row 11
                if (turnNumber == 1) {
                    t111 = -1;
                } else if (turnNumber == 2) {
                    t111 = -2;
                }
                break;
            case 112:
                if (turnNumber == 1) {
                    t112 = -1;
                } else if (turnNumber == 2) {
                    t112 = -2;
                }
                break;
            case 113:
                if (turnNumber == 1) {
                    t113 = -1;
                } else if (turnNumber == 2) {
                    t113 = -2;
                }
                break;
            case 114:
                if (turnNumber == 1) {
                    t114 = -1;
                } else if (turnNumber == 2) {
                    t114 = -2;
                }
                break;
            case 115:
                if (turnNumber == 1) {
                    t115 = -1;
                } else if (turnNumber == 2) {
                    t115 = -2;
                }
                break;
            case 116:
                if (turnNumber == 1) {
                    t116 = -1;
                } else if (turnNumber == 2) {
                    t116 = -2;
                }
                break;
            case 117:
                if (turnNumber == 1) {
                    t117 = -1;
                } else if (turnNumber == 2) {
                    t117 = -2;
                }
                break;
            case 118:
                if (turnNumber == 1) {
                    t118 = -1;
                } else if (turnNumber == 2) {
                    t118 = -2;
                }
                break;
            case 119:
                if (turnNumber == 1) {
                    t119 = -1;
                } else if (turnNumber == 2) {
                    t119 = -2;
                }
                break;          // row 11 completed

            case 121:            // row 12
                if (turnNumber == 1) {
                    t121 = -1;
                } else if (turnNumber == 2) {
                    t121 = -2;
                }
                break;
            case 122:
                if (turnNumber == 1) {
                    t122 = -1;
                } else if (turnNumber == 2) {
                    t122 = -2;
                }
                break;
            case 123:
                if (turnNumber == 1) {
                    t123 = -1;
                } else if (turnNumber == 2) {
                    t123 = -2;
                }
                break;
            case 124:
                if (turnNumber == 1) {
                    t124 = -1;
                } else if (turnNumber == 2) {
                    t124 = -2;
                }
                break;
            case 125:
                if (turnNumber == 1) {
                    t125 = -1;
                } else if (turnNumber == 2) {
                    t125 = -2;
                }
                break;
            case 126:
                if (turnNumber == 1) {
                    t126 = -1;
                } else if (turnNumber == 2) {
                    t126 = -2;
                }
                break;
            case 127:
                if (turnNumber == 1) {
                    t127 = -1;
                } else if (turnNumber == 2) {
                    t127 = -2;
                }
                break;
            case 128:
                if (turnNumber == 1) {
                    t128 = -1;
                } else if (turnNumber == 2) {
                    t128 = -2;
                }
                break;
            case 129:
                if (turnNumber == 1) {
                    t129 = -1;
                } else if (turnNumber == 2) {
                    t129 = -2;
                }
                break;          // row 12 completed
        }
        switch (boxNumbers[r2][c2]) {
            case 11:
                if (turnNumber == 1) {
                    t11 = -1;
                } else if (turnNumber == 2) {
                    t11 = -2;
                }
                break;
            case 12:
                if (turnNumber == 1) {
                    t12 = -1;
                } else if (turnNumber == 2) {
                    t12 = -2;
                }
                break;
            case 13:
                if (turnNumber == 1) {
                    t13 = -1;
                } else if (turnNumber == 2) {
                    t13 = -2;
                }

                break;
            case 14:
                if (turnNumber == 1) {
                    t14 = -1;
                } else if (turnNumber == 2) {
                    t14 = -2;
                }
                break;
            case 15:
                if (turnNumber == 1) {
                    t15 = -1;
                } else if (turnNumber == 2) {
                    t15 = -2;
                }
                break;
            case 16:
                if (turnNumber == 1) {
                    t16 = -1;
                } else if (turnNumber == 2) {
                    t16 = -2;
                }
                break;
            case 17:
                if (turnNumber == 1) {
                    t17 = -1;
                } else if (turnNumber == 2) {
                    t17 = -2;
                }
                break;
            case 18:
                if (turnNumber == 1) {
                    t18 = -1;
                } else if (turnNumber == 2) {
                    t18 = -2;
                }
                break;
            case 19:
                if (turnNumber == 1) {
                    t19 = -1;
                } else if (turnNumber == 2) {
                    t19 = -2;
                }
                break;          // row 1 completed

            case 21:            // row 2
                if (turnNumber == 1) {
                    t21 = -1;
                } else if (turnNumber == 2) {
                    t21 = -2;
                }
                break;
            case 22:
                if (turnNumber == 1) {
                    t22 = -1;
                } else if (turnNumber == 2) {
                    t22 = -2;
                }
                break;
            case 23:
                if (turnNumber == 1) {
                    t23 = -1;
                } else if (turnNumber == 2) {
                    t23 = -2;
                }
                break;
            case 24:
                if (turnNumber == 1) {
                    t24 = -1;
                } else if (turnNumber == 2) {
                    t24 = -2;
                }
                break;
            case 25:
                if (turnNumber == 1) {
                    t25 = -1;
                } else if (turnNumber == 2) {
                    t25 = -2;
                }
                break;
            case 26:
                if (turnNumber == 1) {
                    t26 = -1;
                } else if (turnNumber == 2) {
                    t26 = -2;
                }
                break;
            case 27:
                if (turnNumber == 1) {
                    t27 = -1;
                } else if (turnNumber == 2) {
                    t27 = -2;
                }
                break;
            case 28:
                if (turnNumber == 1) {
                    t28 = -1;
                } else if (turnNumber == 2) {
                    t28 = -2;
                }
                break;
            case 29:
                if (turnNumber == 1) {
                    t29 = -1;
                } else if (turnNumber == 2) {
                    t29 = -2;
                }
                break;          // row 2 completed

            case 31:            // row 3
                if (turnNumber == 1) {
                    t31 = -1;
                } else if (turnNumber == 2) {
                    t31 = -2;
                }
                break;
            case 32:
                if (turnNumber == 1) {
                    t32 = -1;
                } else if (turnNumber == 2) {
                    t32 = -2;
                }
                break;
            case 33:
                if (turnNumber == 1) {
                    t33 = -1;
                } else if (turnNumber == 2) {
                    t33 = -2;
                }
                break;
            case 34:
                if (turnNumber == 1) {
                    t34 = -1;
                } else if (turnNumber == 2) {
                    t34 = -2;
                }
                break;
            case 35:
                if (turnNumber == 1) {
                    t35 = -1;
                } else if (turnNumber == 2) {
                    t35 = -2;
                }
                break;
            case 36:
                if (turnNumber == 1) {
                    t36 = -1;
                } else if (turnNumber == 2) {
                    t36 = -2;
                }
                break;
            case 37:
                if (turnNumber == 1) {
                    t37 = -1;
                } else if (turnNumber == 2) {
                    t37 = -2;
                }
                break;
            case 38:
                if (turnNumber == 1) {
                    t38 = -1;
                } else if (turnNumber == 2) {
                    t38 = -2;
                }
                break;
            case 39:
                if (turnNumber == 1) {
                    t39 = -1;
                } else if (turnNumber == 2) {
                    t39 = -2;
                }
                break;          // row 3 completed

            case 41:            // row 4
                if (turnNumber == 1) {
                    t41 = -1;
                } else if (turnNumber == 2) {
                    t41 = -2;
                }
                break;
            case 42:
                if (turnNumber == 1) {
                    t42 = -1;
                } else if (turnNumber == 2) {
                    t42 = -2;
                }
                break;
            case 43:
                if (turnNumber == 1) {
                    t43 = -1;
                } else if (turnNumber == 2) {
                    t43 = -2;
                }
                break;
            case 44:
                if (turnNumber == 1) {
                    t44 = -1;
                } else if (turnNumber == 2) {
                    t44 = -2;
                }
                break;
            case 45:
                if (turnNumber == 1) {
                    t45 = -1;
                } else if (turnNumber == 2) {
                    t45 = -2;
                }
                break;
            case 46:
                if (turnNumber == 1) {
                    t46 = -1;
                } else if (turnNumber == 2) {
                    t46 = -2;
                }
                break;
            case 47:
                if (turnNumber == 1) {
                    t47 = -1;
                } else if (turnNumber == 2) {
                    t47 = -2;
                }
                break;
            case 48:
                if (turnNumber == 1) {
                    t48 = -1;
                } else if (turnNumber == 2) {
                    t48 = -2;
                }
                break;
            case 49:
                if (turnNumber == 1) {
                    t49 = -1;
                } else if (turnNumber == 2) {
                    t49 = -2;
                }
                break;          // row 4 completed

            case 51:            // row 5
                if (turnNumber == 1) {
                    t51 = -1;
                } else if (turnNumber == 2) {
                    t51 = -2;
                }
                break;
            case 52:
                if (turnNumber == 1) {
                    t52 = -1;
                } else if (turnNumber == 2) {
                    t52 = -2;
                }
                break;
            case 53:
                if (turnNumber == 1) {
                    t53 = -1;
                } else if (turnNumber == 2) {
                    t53 = -2;
                }
                break;
            case 54:
                if (turnNumber == 1) {
                    t54 = -1;
                } else if (turnNumber == 2) {
                    t54 = -2;
                }
                break;
            case 55:
                if (turnNumber == 1) {
                    t55 = -1;
                } else if (turnNumber == 2) {
                    t55 = -2;
                }
                break;
            case 56:
                if (turnNumber == 1) {
                    t56 = -1;
                } else if (turnNumber == 2) {
                    t56 = -2;
                }
                break;
            case 57:
                if (turnNumber == 1) {
                    t57 = -1;
                } else if (turnNumber == 2) {
                    t57 = -2;
                }
                break;
            case 58:
                if (turnNumber == 1) {
                    t58 = -1;
                } else if (turnNumber == 2) {
                    t58 = -2;
                }
                break;
            case 59:
                if (turnNumber == 1) {
                    t59 = -1;
                } else if (turnNumber == 2) {
                    t59 = -2;
                }
                break;          // row 5 completed

            case 61:            // row 6
                if (turnNumber == 1) {
                    t61 = -1;
                } else if (turnNumber == 2) {
                    t61 = -2;
                }
                break;
            case 62:
                if (turnNumber == 1) {
                    t62 = -1;
                } else if (turnNumber == 2) {
                    t62 = -2;
                }
                break;
            case 63:
                if (turnNumber == 1) {
                    t63 = -1;
                } else if (turnNumber == 2) {
                    t63 = -2;
                }
                break;
            case 64:
                if (turnNumber == 1) {
                    t64 = -1;
                } else if (turnNumber == 2) {
                    t64 = -2;
                }
                break;
            case 65:
                if (turnNumber == 1) {
                    t65 = -1;
                } else if (turnNumber == 2) {
                    t65 = -2;
                }
                break;
            case 66:
                if (turnNumber == 1) {
                    t66 = -1;
                } else if (turnNumber == 2) {
                    t66 = -2;
                }
                break;
            case 67:
                if (turnNumber == 1) {
                    t67 = -1;
                } else if (turnNumber == 2) {
                    t67 = -2;
                }
                break;
            case 68:
                if (turnNumber == 1) {
                    t68 = -1;
                } else if (turnNumber == 2) {
                    t68 = -2;
                }
                break;
            case 69:
                if (turnNumber == 1) {
                    t69 = -1;
                } else if (turnNumber == 2) {
                    t69 = -2;
                }
                break;          // row 6 completed

            case 71:            // row 7
                if (turnNumber == 1) {
                    t71 = -1;
                } else if (turnNumber == 2) {
                    t71 = -2;
                }
                break;
            case 72:
                if (turnNumber == 1) {
                    t72 = -1;
                } else if (turnNumber == 2) {
                    t72 = -2;
                }
                break;
            case 73:
                if (turnNumber == 1) {
                    t73 = -1;
                } else if (turnNumber == 2) {
                    t73 = -2;
                }
                break;
            case 74:
                if (turnNumber == 1) {
                    t74 = -1;
                } else if (turnNumber == 2) {
                    t74 = -2;
                }
                break;
            case 75:
                if (turnNumber == 1) {
                    t75 = -1;
                } else if (turnNumber == 2) {
                    t75 = -2;
                }
                break;
            case 76:
                if (turnNumber == 1) {
                    t76 = -1;
                } else if (turnNumber == 2) {
                    t76 = -2;
                }
                break;
            case 77:
                if (turnNumber == 1) {
                    t77 = -1;
                } else if (turnNumber == 2) {
                    t77 = -2;
                }
                break;
            case 78:
                if (turnNumber == 1) {
                    t78 = -1;
                } else if (turnNumber == 2) {
                    t78 = -2;
                }
                break;
            case 79:
                if (turnNumber == 1) {
                    t79 = -1;
                } else if (turnNumber == 2) {
                    t79 = -2;
                }
                break;          // row 7 completed

            case 81:            // row 8
                if (turnNumber == 1) {
                    t81 = -1;
                } else if (turnNumber == 2) {
                    t81 = -2;
                }
                break;
            case 82:
                if (turnNumber == 1) {
                    t82 = -1;
                } else if (turnNumber == 2) {
                    t82 = -2;
                }
                break;
            case 83:
                if (turnNumber == 1) {
                    t83 = -1;
                } else if (turnNumber == 2) {
                    t83 = -2;
                }
                break;
            case 84:
                if (turnNumber == 1) {
                    t84 = -1;
                } else if (turnNumber == 2) {
                    t84 = -2;
                }
                break;
            case 85:
                if (turnNumber == 1) {
                    t85 = -1;
                } else if (turnNumber == 2) {
                    t85 = -2;
                }
                break;
            case 86:
                if (turnNumber == 1) {
                    t86 = -1;
                } else if (turnNumber == 2) {
                    t86 = -2;
                }
                break;
            case 87:
                if (turnNumber == 1) {
                    t87 = -1;
                } else if (turnNumber == 2) {
                    t87 = -2;
                }
                break;
            case 88:
                if (turnNumber == 1) {
                    t88 = -1;
                } else if (turnNumber == 2) {
                    t88 = -2;
                }
                break;
            case 89:
                if (turnNumber == 1) {
                    t89 = -1;
                } else if (turnNumber == 2) {
                    t89 = -2;
                }
                break;          // row 8 completed

            case 91:            // row 9
                if (turnNumber == 1) {
                    t91 = -1;
                } else if (turnNumber == 2) {
                    t91 = -2;
                }
                break;
            case 92:
                if (turnNumber == 1) {
                    t92 = -1;
                } else if (turnNumber == 2) {
                    t92 = -2;
                }
                break;
            case 93:
                if (turnNumber == 1) {
                    t93 = -1;
                } else if (turnNumber == 2) {
                    t93 = -2;
                }
                break;
            case 94:
                if (turnNumber == 1) {
                    t94 = -1;
                } else if (turnNumber == 2) {
                    t94 = -2;
                }
                break;
            case 95:
                if (turnNumber == 1) {
                    t95 = -1;
                } else if (turnNumber == 2) {
                    t95 = -2;
                }
                break;
            case 96:
                if (turnNumber == 1) {
                    t96 = -1;
                } else if (turnNumber == 2) {
                    t96 = -2;
                }
                break;
            case 97:
                if (turnNumber == 1) {
                    t97 = -1;
                } else if (turnNumber == 2) {
                    t97 = -2;
                }
                break;
            case 98:
                if (turnNumber == 1) {
                    t98 = -1;
                } else if (turnNumber == 2) {
                    t98 = -2;
                }
                break;
            case 99:
                if (turnNumber == 1) {
                    t99 = -1;
                } else if (turnNumber == 2) {
                    t99 = -2;
                }
                break;          // row 9 completed

            case 101:            // row 10
                if (turnNumber == 1) {
                    t101 = -1;
                } else if (turnNumber == 2) {
                    t101 = -2;
                }
                break;
            case 102:
                if (turnNumber == 1) {
                    t102 = -1;
                } else if (turnNumber == 2) {
                    t102 = -2;
                }
                break;
            case 103:
                if (turnNumber == 1) {
                    t103 = -1;
                } else if (turnNumber == 2) {
                    t103 = -2;
                }
                break;
            case 104:
                if (turnNumber == 1) {
                    t104 = -1;
                } else if (turnNumber == 2) {
                    t104 = -2;
                }
                break;
            case 105:
                if (turnNumber == 1) {
                    t105 = -1;
                } else if (turnNumber == 2) {
                    t105 = -2;
                }
                break;
            case 106:
                if (turnNumber == 1) {
                    t106 = -1;
                } else if (turnNumber == 2) {
                    t106 = -2;
                }
                break;
            case 107:
                if (turnNumber == 1) {
                    t107 = -1;
                } else if (turnNumber == 2) {
                    t107 = -2;
                }
                break;
            case 108:
                if (turnNumber == 1) {
                    t108 = -1;
                } else if (turnNumber == 2) {
                    t108 = -2;
                }
                break;
            case 109:
                if (turnNumber == 1) {
                    t109 = -1;
                } else if (turnNumber == 2) {
                    t109 = -2;
                }
                break;          // row 10 completed

            case 111:            // row 11
                if (turnNumber == 1) {
                    t111 = -1;
                } else if (turnNumber == 2) {
                    t111 = -2;
                }
                break;
            case 112:
                if (turnNumber == 1) {
                    t112 = -1;
                } else if (turnNumber == 2) {
                    t112 = -2;
                }
                break;
            case 113:
                if (turnNumber == 1) {
                    t113 = -1;
                } else if (turnNumber == 2) {
                    t113 = -2;
                }
                break;
            case 114:
                if (turnNumber == 1) {
                    t114 = -1;
                } else if (turnNumber == 2) {
                    t114 = -2;
                }
                break;
            case 115:
                if (turnNumber == 1) {
                    t115 = -1;
                } else if (turnNumber == 2) {
                    t115 = -2;
                }
                break;
            case 116:
                if (turnNumber == 1) {
                    t116 = -1;
                } else if (turnNumber == 2) {
                    t116 = -2;
                }
                break;
            case 117:
                if (turnNumber == 1) {
                    t117 = -1;
                } else if (turnNumber == 2) {
                    t117 = -2;
                }
                break;
            case 118:
                if (turnNumber == 1) {
                    t118 = -1;
                } else if (turnNumber == 2) {
                    t118 = -2;
                }
                break;
            case 119:
                if (turnNumber == 1) {
                    t119 = -1;
                } else if (turnNumber == 2) {
                    t119 = -2;
                }
                break;          // row 11 completed

            case 121:            // row 12
                if (turnNumber == 1) {
                    t121 = -1;
                } else if (turnNumber == 2) {
                    t121 = -2;
                }
                break;
            case 122:
                if (turnNumber == 1) {
                    t122 = -1;
                } else if (turnNumber == 2) {
                    t122 = -2;
                }
                break;
            case 123:
                if (turnNumber == 1) {
                    t123 = -1;
                } else if (turnNumber == 2) {
                    t123 = -2;
                }
                break;
            case 124:
                if (turnNumber == 1) {
                    t124 = -1;
                } else if (turnNumber == 2) {
                    t124 = -2;
                }
                break;
            case 125:
                if (turnNumber == 1) {
                    t125 = -1;
                } else if (turnNumber == 2) {
                    t125 = -2;
                }
                break;
            case 126:
                if (turnNumber == 1) {
                    t126 = -1;
                } else if (turnNumber == 2) {
                    t126 = -2;
                }
                break;
            case 127:
                if (turnNumber == 1) {
                    t127 = -1;
                } else if (turnNumber == 2) {
                    t127 = -2;
                }
                break;
            case 128:
                if (turnNumber == 1) {
                    t128 = -1;
                } else if (turnNumber == 2) {
                    t128 = -2;
                }
                break;
            case 129:
                if (turnNumber == 1) {
                    t129 = -1;
                } else if (turnNumber == 2) {
                    t129 = -2;
                }
                break;          // row 12 completed
        }

        switch (boxNumbers[r3][c3]) {
            case 11:
                if (turnNumber == 1) {
                    t11 = -1;
                } else if (turnNumber == 2) {
                    t11 = -2;
                }
                break;
            case 12:
                if (turnNumber == 1) {
                    t12 = -1;
                } else if (turnNumber == 2) {
                    t12 = -2;
                }
                break;
            case 13:
                if (turnNumber == 1) {
                    t13 = -1;
                } else if (turnNumber == 2) {
                    t13 = -2;
                }

                break;
            case 14:
                if (turnNumber == 1) {
                    t14 = -1;
                } else if (turnNumber == 2) {
                    t14 = -2;
                }
                break;
            case 15:
                if (turnNumber == 1) {
                    t15 = -1;
                } else if (turnNumber == 2) {
                    t15 = -2;
                }
                break;
            case 16:
                if (turnNumber == 1) {
                    t16 = -1;
                } else if (turnNumber == 2) {
                    t16 = -2;
                }
                break;
            case 17:
                if (turnNumber == 1) {
                    t17 = -1;
                } else if (turnNumber == 2) {
                    t17 = -2;
                }
                break;
            case 18:
                if (turnNumber == 1) {
                    t18 = -1;
                } else if (turnNumber == 2) {
                    t18 = -2;
                }
                break;
            case 19:
                if (turnNumber == 1) {
                    t19 = -1;
                } else if (turnNumber == 2) {
                    t19 = -2;
                }
                break;          // row 1 completed

            case 21:            // row 2
                if (turnNumber == 1) {
                    t21 = -1;
                } else if (turnNumber == 2) {
                    t21 = -2;
                }
                break;
            case 22:
                if (turnNumber == 1) {
                    t22 = -1;
                } else if (turnNumber == 2) {
                    t22 = -2;
                }
                break;
            case 23:
                if (turnNumber == 1) {
                    t23 = -1;
                } else if (turnNumber == 2) {
                    t23 = -2;
                }
                break;
            case 24:
                if (turnNumber == 1) {
                    t24 = -1;
                } else if (turnNumber == 2) {
                    t24 = -2;
                }
                break;
            case 25:
                if (turnNumber == 1) {
                    t25 = -1;
                } else if (turnNumber == 2) {
                    t25 = -2;
                }
                break;
            case 26:
                if (turnNumber == 1) {
                    t26 = -1;
                } else if (turnNumber == 2) {
                    t26 = -2;
                }
                break;
            case 27:
                if (turnNumber == 1) {
                    t27 = -1;
                } else if (turnNumber == 2) {
                    t27 = -2;
                }
                break;
            case 28:
                if (turnNumber == 1) {
                    t28 = -1;
                } else if (turnNumber == 2) {
                    t28 = -2;
                }
                break;
            case 29:
                if (turnNumber == 1) {
                    t29 = -1;
                } else if (turnNumber == 2) {
                    t29 = -2;
                }
                break;          // row 2 completed

            case 31:            // row 3
                if (turnNumber == 1) {
                    t31 = -1;
                } else if (turnNumber == 2) {
                    t31 = -2;
                }
                break;
            case 32:
                if (turnNumber == 1) {
                    t32 = -1;
                } else if (turnNumber == 2) {
                    t32 = -2;
                }
                break;
            case 33:
                if (turnNumber == 1) {
                    t33 = -1;
                } else if (turnNumber == 2) {
                    t33 = -2;
                }
                break;
            case 34:
                if (turnNumber == 1) {
                    t34 = -1;
                } else if (turnNumber == 2) {
                    t34 = -2;
                }
                break;
            case 35:
                if (turnNumber == 1) {
                    t35 = -1;
                } else if (turnNumber == 2) {
                    t35 = -2;
                }
                break;
            case 36:
                if (turnNumber == 1) {
                    t36 = -1;
                } else if (turnNumber == 2) {
                    t36 = -2;
                }
                break;
            case 37:
                if (turnNumber == 1) {
                    t37 = -1;
                } else if (turnNumber == 2) {
                    t37 = -2;
                }
                break;
            case 38:
                if (turnNumber == 1) {
                    t38 = -1;
                } else if (turnNumber == 2) {
                    t38 = -2;
                }
                break;
            case 39:
                if (turnNumber == 1) {
                    t39 = -1;
                } else if (turnNumber == 2) {
                    t39 = -2;
                }
                break;          // row 3 completed

            case 41:            // row 4
                if (turnNumber == 1) {
                    t41 = -1;
                } else if (turnNumber == 2) {
                    t41 = -2;
                }
                break;
            case 42:
                if (turnNumber == 1) {
                    t42 = -1;
                } else if (turnNumber == 2) {
                    t42 = -2;
                }
                break;
            case 43:
                if (turnNumber == 1) {
                    t43 = -1;
                } else if (turnNumber == 2) {
                    t43 = -2;
                }
                break;
            case 44:
                if (turnNumber == 1) {
                    t44 = -1;
                } else if (turnNumber == 2) {
                    t44 = -2;
                }
                break;
            case 45:
                if (turnNumber == 1) {
                    t45 = -1;
                } else if (turnNumber == 2) {
                    t45 = -2;
                }
                break;
            case 46:
                if (turnNumber == 1) {
                    t46 = -1;
                } else if (turnNumber == 2) {
                    t46 = -2;
                }
                break;
            case 47:
                if (turnNumber == 1) {
                    t47 = -1;
                } else if (turnNumber == 2) {
                    t47 = -2;
                }
                break;
            case 48:
                if (turnNumber == 1) {
                    t48 = -1;
                } else if (turnNumber == 2) {
                    t48 = -2;
                }
                break;
            case 49:
                if (turnNumber == 1) {
                    t49 = -1;
                } else if (turnNumber == 2) {
                    t49 = -2;
                }
                break;          // row 4 completed

            case 51:            // row 5
                if (turnNumber == 1) {
                    t51 = -1;
                } else if (turnNumber == 2) {
                    t51 = -2;
                }
                break;
            case 52:
                if (turnNumber == 1) {
                    t52 = -1;
                } else if (turnNumber == 2) {
                    t52 = -2;
                }
                break;
            case 53:
                if (turnNumber == 1) {
                    t53 = -1;
                } else if (turnNumber == 2) {
                    t53 = -2;
                }
                break;
            case 54:
                if (turnNumber == 1) {
                    t54 = -1;
                } else if (turnNumber == 2) {
                    t54 = -2;
                }
                break;
            case 55:
                if (turnNumber == 1) {
                    t55 = -1;
                } else if (turnNumber == 2) {
                    t55 = -2;
                }
                break;
            case 56:
                if (turnNumber == 1) {
                    t56 = -1;
                } else if (turnNumber == 2) {
                    t56 = -2;
                }
                break;
            case 57:
                if (turnNumber == 1) {
                    t57 = -1;
                } else if (turnNumber == 2) {
                    t57 = -2;
                }
                break;
            case 58:
                if (turnNumber == 1) {
                    t58 = -1;
                } else if (turnNumber == 2) {
                    t58 = -2;
                }
                break;
            case 59:
                if (turnNumber == 1) {
                    t59 = -1;
                } else if (turnNumber == 2) {
                    t59 = -2;
                }
                break;          // row 5 completed

            case 61:            // row 6
                if (turnNumber == 1) {
                    t61 = -1;
                } else if (turnNumber == 2) {
                    t61 = -2;
                }
                break;
            case 62:
                if (turnNumber == 1) {
                    t62 = -1;
                } else if (turnNumber == 2) {
                    t62 = -2;
                }
                break;
            case 63:
                if (turnNumber == 1) {
                    t63 = -1;
                } else if (turnNumber == 2) {
                    t63 = -2;
                }
                break;
            case 64:
                if (turnNumber == 1) {
                    t64 = -1;
                } else if (turnNumber == 2) {
                    t64 = -2;
                }
                break;
            case 65:
                if (turnNumber == 1) {
                    t65 = -1;
                } else if (turnNumber == 2) {
                    t65 = -2;
                }
                break;
            case 66:
                if (turnNumber == 1) {
                    t66 = -1;
                } else if (turnNumber == 2) {
                    t66 = -2;
                }
                break;
            case 67:
                if (turnNumber == 1) {
                    t67 = -1;
                } else if (turnNumber == 2) {
                    t67 = -2;
                }
                break;
            case 68:
                if (turnNumber == 1) {
                    t68 = -1;
                } else if (turnNumber == 2) {
                    t68 = -2;
                }
                break;
            case 69:
                if (turnNumber == 1) {
                    t69 = -1;
                } else if (turnNumber == 2) {
                    t69 = -2;
                }
                break;          // row 6 completed

            case 71:            // row 7
                if (turnNumber == 1) {
                    t71 = -1;
                } else if (turnNumber == 2) {
                    t71 = -2;
                }
                break;
            case 72:
                if (turnNumber == 1) {
                    t72 = -1;
                } else if (turnNumber == 2) {
                    t72 = -2;
                }
                break;
            case 73:
                if (turnNumber == 1) {
                    t73 = -1;
                } else if (turnNumber == 2) {
                    t73 = -2;
                }
                break;
            case 74:
                if (turnNumber == 1) {
                    t74 = -1;
                } else if (turnNumber == 2) {
                    t74 = -2;
                }
                break;
            case 75:
                if (turnNumber == 1) {
                    t75 = -1;
                } else if (turnNumber == 2) {
                    t75 = -2;
                }
                break;
            case 76:
                if (turnNumber == 1) {
                    t76 = -1;
                } else if (turnNumber == 2) {
                    t76 = -2;
                }
                break;
            case 77:
                if (turnNumber == 1) {
                    t77 = -1;
                } else if (turnNumber == 2) {
                    t77 = -2;
                }
                break;
            case 78:
                if (turnNumber == 1) {
                    t78 = -1;
                } else if (turnNumber == 2) {
                    t78 = -2;
                }
                break;
            case 79:
                if (turnNumber == 1) {
                    t79 = -1;
                } else if (turnNumber == 2) {
                    t79 = -2;
                }
                break;          // row 7 completed

            case 81:            // row 8
                if (turnNumber == 1) {
                    t81 = -1;
                } else if (turnNumber == 2) {
                    t81 = -2;
                }
                break;
            case 82:
                if (turnNumber == 1) {
                    t82 = -1;
                } else if (turnNumber == 2) {
                    t82 = -2;
                }
                break;
            case 83:
                if (turnNumber == 1) {
                    t83 = -1;
                } else if (turnNumber == 2) {
                    t83 = -2;
                }
                break;
            case 84:
                if (turnNumber == 1) {
                    t84 = -1;
                } else if (turnNumber == 2) {
                    t84 = -2;
                }
                break;
            case 85:
                if (turnNumber == 1) {
                    t85 = -1;
                } else if (turnNumber == 2) {
                    t85 = -2;
                }
                break;
            case 86:
                if (turnNumber == 1) {
                    t86 = -1;
                } else if (turnNumber == 2) {
                    t86 = -2;
                }
                break;
            case 87:
                if (turnNumber == 1) {
                    t87 = -1;
                } else if (turnNumber == 2) {
                    t87 = -2;
                }
                break;
            case 88:
                if (turnNumber == 1) {
                    t88 = -1;
                } else if (turnNumber == 2) {
                    t88 = -2;
                }
                break;
            case 89:
                if (turnNumber == 1) {
                    t89 = -1;
                } else if (turnNumber == 2) {
                    t89 = -2;
                }
                break;          // row 8 completed

            case 91:            // row 9
                if (turnNumber == 1) {
                    t91 = -1;
                } else if (turnNumber == 2) {
                    t91 = -2;
                }
                break;
            case 92:
                if (turnNumber == 1) {
                    t92 = -1;
                } else if (turnNumber == 2) {
                    t92 = -2;
                }
                break;
            case 93:
                if (turnNumber == 1) {
                    t93 = -1;
                } else if (turnNumber == 2) {
                    t93 = -2;
                }
                break;
            case 94:
                if (turnNumber == 1) {
                    t94 = -1;
                } else if (turnNumber == 2) {
                    t94 = -2;
                }
                break;
            case 95:
                if (turnNumber == 1) {
                    t95 = -1;
                } else if (turnNumber == 2) {
                    t95 = -2;
                }
                break;
            case 96:
                if (turnNumber == 1) {
                    t96 = -1;
                } else if (turnNumber == 2) {
                    t96 = -2;
                }
                break;
            case 97:
                if (turnNumber == 1) {
                    t97 = -1;
                } else if (turnNumber == 2) {
                    t97 = -2;
                }
                break;
            case 98:
                if (turnNumber == 1) {
                    t98 = -1;
                } else if (turnNumber == 2) {
                    t98 = -2;
                }
                break;
            case 99:
                if (turnNumber == 1) {
                    t99 = -1;
                } else if (turnNumber == 2) {
                    t99 = -2;
                }
                break;          // row 9 completed

            case 101:            // row 10
                if (turnNumber == 1) {
                    t101 = -1;
                } else if (turnNumber == 2) {
                    t101 = -2;
                }
                break;
            case 102:
                if (turnNumber == 1) {
                    t102 = -1;
                } else if (turnNumber == 2) {
                    t102 = -2;
                }
                break;
            case 103:
                if (turnNumber == 1) {
                    t103 = -1;
                } else if (turnNumber == 2) {
                    t103 = -2;
                }
                break;
            case 104:
                if (turnNumber == 1) {
                    t104 = -1;
                } else if (turnNumber == 2) {
                    t104 = -2;
                }
                break;
            case 105:
                if (turnNumber == 1) {
                    t105 = -1;
                } else if (turnNumber == 2) {
                    t105 = -2;
                }
                break;
            case 106:
                if (turnNumber == 1) {
                    t106 = -1;
                } else if (turnNumber == 2) {
                    t106 = -2;
                }
                break;
            case 107:
                if (turnNumber == 1) {
                    t107 = -1;
                } else if (turnNumber == 2) {
                    t107 = -2;
                }
                break;
            case 108:
                if (turnNumber == 1) {
                    t108 = -1;
                } else if (turnNumber == 2) {
                    t108 = -2;
                }
                break;
            case 109:
                if (turnNumber == 1) {
                    t109 = -1;
                } else if (turnNumber == 2) {
                    t109 = -2;
                }
                break;          // row 10 completed

            case 111:            // row 11
                if (turnNumber == 1) {
                    t111 = -1;
                } else if (turnNumber == 2) {
                    t111 = -2;
                }
                break;
            case 112:
                if (turnNumber == 1) {
                    t112 = -1;
                } else if (turnNumber == 2) {
                    t112 = -2;
                }
                break;
            case 113:
                if (turnNumber == 1) {
                    t113 = -1;
                } else if (turnNumber == 2) {
                    t113 = -2;
                }
                break;
            case 114:
                if (turnNumber == 1) {
                    t114 = -1;
                } else if (turnNumber == 2) {
                    t114 = -2;
                }
                break;
            case 115:
                if (turnNumber == 1) {
                    t115 = -1;
                } else if (turnNumber == 2) {
                    t115 = -2;
                }
                break;
            case 116:
                if (turnNumber == 1) {
                    t116 = -1;
                } else if (turnNumber == 2) {
                    t116 = -2;
                }
                break;
            case 117:
                if (turnNumber == 1) {
                    t117 = -1;
                } else if (turnNumber == 2) {
                    t117 = -2;
                }
                break;
            case 118:
                if (turnNumber == 1) {
                    t118 = -1;
                } else if (turnNumber == 2) {
                    t118 = -2;
                }
                break;
            case 119:
                if (turnNumber == 1) {
                    t119 = -1;
                } else if (turnNumber == 2) {
                    t119 = -2;
                }
                break;          // row 11 completed

            case 121:            // row 12
                if (turnNumber == 1) {
                    t121 = -1;
                } else if (turnNumber == 2) {
                    t121 = -2;
                }
                break;
            case 122:
                if (turnNumber == 1) {
                    t122 = -1;
                } else if (turnNumber == 2) {
                    t122 = -2;
                }
                break;
            case 123:
                if (turnNumber == 1) {
                    t123 = -1;
                } else if (turnNumber == 2) {
                    t123 = -2;
                }
                break;
            case 124:
                if (turnNumber == 1) {
                    t124 = -1;
                } else if (turnNumber == 2) {
                    t124 = -2;
                }
                break;
            case 125:
                if (turnNumber == 1) {
                    t125 = -1;
                } else if (turnNumber == 2) {
                    t125 = -2;
                }
                break;
            case 126:
                if (turnNumber == 1) {
                    t126 = -1;
                } else if (turnNumber == 2) {
                    t126 = -2;
                }
                break;
            case 127:
                if (turnNumber == 1) {
                    t127 = -1;
                } else if (turnNumber == 2) {
                    t127 = -2;
                }
                break;
            case 128:
                if (turnNumber == 1) {
                    t128 = -1;
                } else if (turnNumber == 2) {
                    t128 = -2;
                }
                break;
            case 129:
                if (turnNumber == 1) {
                    t129 = -1;
                } else if (turnNumber == 2) {
                    t129 = -2;
                }
                break;          // row 12 completed
        }

    }

    final void oneMoreChance(boolean check) {
        if (check) {
            binding.turnView.setBackgroundResource(R.drawable.one_more_chance);
        } else {
            binding.turnView.setBackgroundColor(Color.TRANSPARENT);

        }
    }

    final boolean checkGameStatus(int[][] matrix) {

        gameStatus = true;

        abc:
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] == 0) {
                    gameStatus = false;
                    break abc;
                }
            }
        }

        return gameStatus;
    }

    final void changeBackground(int r1, int c1, int r2, int c2, int r3, int c3) {
        if (sounds) {
            playMatchedSound();
        }
        colorSign = true;
        i = 0;
        pivot = 1;

        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {


                if (pivot == 1) {
                    matrixViews[r1][c1].setBackgroundResource(R.color.boxBackground);
                    matrixViews[r2][c2].setBackgroundResource(R.color.boxBackground);
                    matrixViews[r3][c3].setBackgroundResource(R.color.boxBackground);
                    pivot = 2;
                } else if (pivot == 2) {
                    matrixViews[r1][c1].setBackgroundColor(Color.TRANSPARENT);
                    matrixViews[r2][c2].setBackgroundColor(Color.TRANSPARENT);
                    matrixViews[r3][c3].setBackgroundColor(Color.TRANSPARENT);
                    pivot = 1;

                }

                if (i <= 5) {
                    i++;
                    handler.postDelayed(this, 200);
                } else {
                    if (turnNumber == 1) {
                        matrixViews[r1][c1].setBackgroundResource(R.color.player1Background);
                        matrixViews[r2][c2].setBackgroundResource(R.color.player1Background);
                        matrixViews[r3][c3].setBackgroundResource(R.color.player1Background);
                    } else if (turnNumber == 2) {
                        matrixViews[r1][c1].setBackgroundResource(R.color.player2Background);
                        matrixViews[r2][c2].setBackgroundResource(R.color.player2Background);
                        matrixViews[r3][c3].setBackgroundResource(R.color.player2Background);

                    }
                    colorSign = false;
                }
            }
        });


    }


    final void removeBackground() {
        ImageView[][] matrixViews = { // all image views (boxes)
                {binding.tic11View, binding.tic12View, binding.tic13View, binding.tic14View, binding.tic15View, binding.tic16View, binding.tic17View, binding.tic18View, binding.tic19View},
                {binding.tic21View, binding.tic22View, binding.tic23View, binding.tic24View, binding.tic25View, binding.tic26View, binding.tic27View, binding.tic28View, binding.tic29View},
                {binding.tic31View, binding.tic32View, binding.tic33View, binding.tic34View, binding.tic35View, binding.tic36View, binding.tic37View, binding.tic38View, binding.tic39View},
                {binding.tic41View, binding.tic42View, binding.tic43View, binding.tic44View, binding.tic45View, binding.tic46View, binding.tic47View, binding.tic48View, binding.tic49View},
                {binding.tic51View, binding.tic52View, binding.tic53View, binding.tic54View, binding.tic55View, binding.tic56View, binding.tic57View, binding.tic58View, binding.tic59View},
                {binding.tic61View, binding.tic62View, binding.tic63View, binding.tic64View, binding.tic65View, binding.tic66View, binding.tic67View, binding.tic68View, binding.tic69View},
                {binding.tic71View, binding.tic72View, binding.tic73View, binding.tic74View, binding.tic75View, binding.tic76View, binding.tic77View, binding.tic78View, binding.tic79View},
                {binding.tic81View, binding.tic82View, binding.tic83View, binding.tic84View, binding.tic85View, binding.tic86View, binding.tic87View, binding.tic88View, binding.tic89View},
                {binding.tic91View, binding.tic92View, binding.tic93View, binding.tic94View, binding.tic95View, binding.tic96View, binding.tic97View, binding.tic98View, binding.tic99View},
                {binding.tic101View, binding.tic102View, binding.tic103View, binding.tic104View, binding.tic105View, binding.tic106View, binding.tic107View, binding.tic108View, binding.tic109View},
                {binding.tic111View, binding.tic112View, binding.tic113View, binding.tic114View, binding.tic115View, binding.tic116View, binding.tic117View, binding.tic118View, binding.tic119View},
                {binding.tic121View, binding.tic122View, binding.tic123View, binding.tic124View, binding.tic125View, binding.tic126View, binding.tic127View, binding.tic128View, binding.tic129View},

        };

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 9; j++) {
                matrixViews[i][j].setBackgroundColor(Color.TRANSPARENT);
            }
        }

        // removing background of the turn view
        binding.turnView.setBackgroundColor(Color.TRANSPARENT);
    }

    final void addScore() {

        turnChanger = false;
        String score;

        if (turnNumber == 1) {
            player1Score += 10;
            if (player2Score != 0)
                player2Score -= 5;

        } else if (turnNumber == 2) {
            player2Score += 10;
            if (player1Score != 0)
                player1Score -= 5;

        }


        if (player1Score > 0 && player1Score < 10) score = ": 0" + player1Score;
        else score = ": " + player1Score;

        binding.player1Score.setText(score);

        if (player2Score > 0 && player2Score < 10) score = ": 0" + player2Score;
        else score = ": " + player2Score;

        binding.player2Score.setText(score);


    }

    final void changeTurn() {
        if (turnNumber == 1) {
            turnNumber = 2;
            binding.turnView.setImageResource(R.drawable.player_2);
        } else if (turnNumber == 2) {
            turnNumber = 1;
            binding.turnView.setImageResource(R.drawable.player_1);

        }
    }

    void showAlreadyFilled() {
        Toast.makeText(getContext(), "Already filled", Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("SetTextI18n")
    final void setScoreToZero() {
        binding.player1Score.setText(": 00");
        binding.player2Score.setText(": 00");
    }

    final void restartGame() {
        if (sounds) {
            playRestartSound();
        }
        changeTurn();

        t11 = t12 = t13 = t14 = t15 = t16 = t17 = t18 = t19 = t21 = t22 = t23 = t24 = t25 = t26 = t27 = t28 = t29 = t31 = t32 = t33 = t34 = t35 = t36 = t37 = t38 = t39 = 0;
        t41 = t42 = t43 = t44 = t45 = t46 = t47 = t48 = t49 = t51 = t52 = t53 = t54 = t55 = t56 = t57 = t58 = t59 = t61 = t62 = t63 = t64 = t65 = t66 = t67 = t68 = t69 = 0;
        t71 = t72 = t73 = t74 = t75 = t76 = t77 = t78 = t79 = t81 = t82 = t83 = t84 = t85 = t86 = t87 = t88 = t89 = t91 = t92 = t93 = t94 = t95 = t96 = t97 = t98 = t99 = 0;
        t101 = t102 = t103 = t104 = t105 = t106 = t107 = t108 = t109 = t111 = t112 = t113 = t114 = t115 = t116 = t117 = t118 = t119 = t121 = t122 = t123 = t124 = t125 = t126 = t127 = t128 = t129 = 0;

        player1Score = player2Score = 0;

        gameStatus = true;
        turnChanger = restartChecker = false;
        removeBackground();
        setTheVisibility();
        setScoreToZero();

        if (turnNumber == 2) {

            Toast.makeText(getContext(), "Now it's Cross turn", Toast.LENGTH_LONG).show();
        } else if (turnNumber == 1) {
            Toast.makeText(getContext(), "Now it's Circle turn", Toast.LENGTH_LONG).show();
        }
    }

    final void stopSounds() {
        if (player != null) {
            try {
                player.stop();
                player.release();
            } catch (Exception ignored) {
            }
        }
    }

    final void playSound() {
        stopSounds();
        player = MediaPlayer.create(requireContext().getApplicationContext(), R.raw.button_sound);
        player.start();
    }

    final void playRestartSound() {
        stopSounds();
        player = MediaPlayer.create(requireContext().getApplicationContext(), R.raw.restart_sound);
        player.setOnCompletionListener(playerListener);

        player.start();
    }

    final void playMatchedSound() {
        stopSounds();
        player = MediaPlayer.create(requireContext().getApplicationContext(), R.raw.match_sound);
        player.setOnCompletionListener(playerListener);

        player.start();
    }

    final void playWinnerSound() {
        stopSounds();
        player = MediaPlayer.create(requireContext().getApplicationContext(), R.raw.game_won);
        player.setOnCompletionListener(playerListener);

        player.start();
    }

    final void playDrawSound() {
        stopSounds();
        player = MediaPlayer.create(requireContext().getApplicationContext(), R.raw.draw_match);
        player.setOnCompletionListener(playerListener);

        player.start();
    }


    @SuppressLint("SetTextI18n")
    final void showWinnerPoster() {
        playWinnerSound();
        binding.trophyView.setVisibility(View.VISIBLE);
        binding.resultText.setVisibility(View.VISIBLE);
        binding.namePlate.setVisibility(View.VISIBLE);
        binding.gameBoard.setVisibility(View.INVISIBLE);
        binding.restartBtn.setVisibility(View.INVISIBLE);
        binding.linearLayout2.setVisibility(View.INVISIBLE);
        binding.soundSwitch.setVisibility(View.INVISIBLE);


        binding.trophyView.setImageResource(R.drawable.winner);
        binding.resultText.setText("Congratulations...!");

        if (player1Score > player2Score) {
            binding.winnerView.setImageResource(R.drawable.player_1);
            binding.namePlate.setText("Circle player won...");
        } else if (player2Score > player1Score) {
            binding.winnerView.setImageResource(R.drawable.player_2);
            binding.namePlate.setText("Cross player won...");

        } else {
            playDrawSound();
            binding.trophyView.setImageResource(R.drawable.handshake);
            binding.winnerView.setVisibility(View.GONE);
            binding.resultText.setText("Draw..!");
            binding.namePlate.setVisibility(View.GONE);
        }
        binding.wonDialog.setVisibility(View.VISIBLE);
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getContext(), "Check turn and start Game", Toast.LENGTH_LONG).show();
    }

    //    int t11, t12, t13, t14, t15, t16, t17, t18, t19, t21, t22, t23, t24, t25, t26, t27, t28, t29, t31, t32, t33, t34, t35, t36, t37, t38, t39;
//    int t41, t42, t43, t44, t45, t46, t47, t48, t49, t51, t52, t53, t54, t55, t56, t57, t58, t59, t61, t62, t63, t64, t65, t66, t67, t68, t69;
//    int t71, t72, t73, t74, t75, t76, t77, t78, t79, t81, t82, t83, t84, t85, t86, t87, t88, t89, t91, t92, t93, t94, t95, t96, t97, t98, t99;
//    int t101, t102, t103, t104, t105, t106, t107, t108, t109, t111, t112, t113, t114, t115, t116, t117, t118, t119, t121, t122, t123, t124, t125, t126, t127, t128, t129;


//    ImageView[][] matrixViews = {
//            {binding.tic11View, binding.tic12View, binding.tic13View, binding.tic14View, binding.tic15View, binding.tic16View, binding.tic17View, binding.tic18View, binding.tic19View},
//            {binding.tic21View, binding.tic22View, binding.tic23View, binding.tic24View, binding.tic25View, binding.tic26View, binding.tic27View, binding.tic28View, binding.tic29View},
//            {binding.tic31View, binding.tic32View, binding.tic33View, binding.tic34View, binding.tic35View, binding.tic36View, binding.tic37View, binding.tic38View, binding.tic39View},
//            {binding.tic41View, binding.tic42View, binding.tic43View, binding.tic44View, binding.tic45View, binding.tic46View, binding.tic47View, binding.tic48View, binding.tic49View},
//            {binding.tic51View, binding.tic52View, binding.tic53View, binding.tic54View, binding.tic55View, binding.tic56View, binding.tic57View, binding.tic58View, binding.tic59View},
//            {binding.tic61View, binding.tic62View, binding.tic63View, binding.tic64View, binding.tic65View, binding.tic66View, binding.tic67View, binding.tic68View, binding.tic69View},
//            {binding.tic71View, binding.tic72View, binding.tic73View, binding.tic74View, binding.tic75View, binding.tic76View, binding.tic77View, binding.tic78View, binding.tic79View},
//            {binding.tic81View, binding.tic82View, binding.tic83View, binding.tic84View, binding.tic85View, binding.tic86View, binding.tic87View, binding.tic88View, binding.tic89View},
//            {binding.tic91View, binding.tic92View, binding.tic93View, binding.tic94View, binding.tic95View, binding.tic96View, binding.tic97View, binding.tic98View, binding.tic99View},
//            {binding.tic101View, binding.tic102View, binding.tic103View, binding.tic104View, binding.tic105View, binding.tic106View, binding.tic107View, binding.tic108View, binding.tic109View},
//            {binding.tic111View, binding.tic112View, binding.tic113View, binding.tic114View, binding.tic115View, binding.tic116View, binding.tic117View, binding.tic118View, binding.tic119View},
//            {binding.tic121View, binding.tic122View, binding.tic123View, binding.tic124View, binding.tic125View, binding.tic126View, binding.tic127View, binding.tic128View, binding.tic129View},
//
//    };

//    int[][] boxNumbers = {{11, 12, 13, 14, 15, 16, 17, 18, 19},
//            {21, 22, 23, 24, 25, 26, 27, 28, 29},
//            {31, 32, 33, 34, 35, 36, 37, 38, 39},
//            {41, 42, 43, 44, 45, 46, 47, 48, 49},
//            {51, 52, 53, 54, 55, 56, 57, 58, 59},
//            {61, 62, 63, 64, 65, 66, 67, 68, 69},
//            {71, 72, 73, 74, 75, 76, 77, 78, 79},
//            {81, 82, 83, 84, 85, 86, 87, 88, 89},
//            {91, 92, 93, 94, 95, 96, 97, 98, 99},
//            {101, 102, 103, 104, 105, 106, 107, 108, 109},
//            {111, 112, 113, 114, 115, 116, 117, 118, 119},
//            {121, 122, 123, 124, 125, 126, 127, 128, 129},
//
//
//    };

}