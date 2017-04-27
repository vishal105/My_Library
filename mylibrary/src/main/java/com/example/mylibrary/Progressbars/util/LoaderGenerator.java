package com.example.mylibrary.Progressbars.util;


import com.example.mylibrary.Progressbars.exception.InvalidNumberOfPulseException;
import com.example.mylibrary.Progressbars.type.ClassicSpinner;
import com.example.mylibrary.Progressbars.type.FishSpinner;
import com.example.mylibrary.Progressbars.type.LineSpinner;
import com.example.mylibrary.Progressbars.type.LoaderView;
import com.example.mylibrary.Progressbars.type.PhoneWave;
import com.example.mylibrary.Progressbars.type.Pulse;
import com.example.mylibrary.Progressbars.type.Radar;
import com.example.mylibrary.Progressbars.type.Sharingan;
import com.example.mylibrary.Progressbars.type.TwinFishesSpinner;
import com.example.mylibrary.Progressbars.type.Whirlpool;
import com.example.mylibrary.Progressbars.type.Worm;

/**
 * Created by Tuyen Nguyen on 2/13/17.
 */

public class LoaderGenerator {

  public static LoaderView generateLoaderView(int type) {
    switch (type) {
      case 0:
        return new ClassicSpinner();
      case 1:
        return new FishSpinner();
      case 2:
        return new LineSpinner();
      case 3:
        try {
          return new Pulse(3);
        } catch (InvalidNumberOfPulseException e) {
          e.printStackTrace();
        }
      case 4:
        try {
          return new Pulse(4);
        } catch (InvalidNumberOfPulseException e) {
          e.printStackTrace();
        }
      case 5:
        try {
          return new Pulse(5);
        } catch (InvalidNumberOfPulseException e) {
          e.printStackTrace();
        }
      case 6:
        return new Radar();
      case 7:
        return new TwinFishesSpinner();
      case 8:
        return new Worm();
      case 9:
        return new Whirlpool();
      case 10:
        return new PhoneWave();
      case 11:
        return new Sharingan();
      default:
        return new ClassicSpinner();
    }
  }

  public static LoaderView generateLoaderView(String type) {
    switch (type) {
      case "ClassicSpinner":
        return new ClassicSpinner();
      case "FishSpinner":
        return new FishSpinner();
      case "LineSpinner":
        return new LineSpinner();
      case "ThreePulse":
        try {
          return new Pulse(3);
        } catch (InvalidNumberOfPulseException e) {
          e.printStackTrace();
        }
      case "FourPulse":
        try {
          return new Pulse(4);
        } catch (InvalidNumberOfPulseException e) {
          e.printStackTrace();
        }
      case "FivePulse":
        try {
          return new Pulse(5);
        } catch (InvalidNumberOfPulseException e) {
          e.printStackTrace();
        }
      case "Radar":
        return new Radar();
      case "TwinFishesSpinner":
        return new TwinFishesSpinner();
      case "Worm":
        return new Worm();
      case "Whirlpool":
        return new Whirlpool();
      case "PhoneWave":
        return new PhoneWave();
      case "Sharingan":
        return new Sharingan();
      default:
        return new ClassicSpinner();
    }
  }
}
