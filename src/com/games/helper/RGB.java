package com.games.helper;

public class RGB {

    public float R, G, B;
    private boolean isUp = true;

    public void RedColor(){
        R = 1f;
        G = 0f;
        B = 0f;
    }

    public void GreenColor(){
        R = 0f;
        G = 1f;
        B = 0f;
    }

    public void BlueColor(){
        R = 0f;
        G = 0f;
        B = 1f;
    }

    public void RGB_Change_Color_Rainbow(float perubahan){
        //        R = (isUp) ? (R >= 1f) ? 1f : R+0.1f : (R <= 0f) ? 0f : (G > 0f) ? 1f : R-0.1f;
//
//        G = (isUp) ? (G >= 1f) ? 1f :   (R < 1f) ? 0 : G+0.1f   :   (B >= 0.1f) ? 1f : (G <= 0.1f) ? 0f : G-0.1f;
//
//        if (R == 1f && G == 1f) {
//            if (isUp) {
//                B = (B > 1f) ? 1f : B;
//                if (B > 1f ) {
//                    isUp = false;
//                } else {
//                    B += 0.1f;
//                }
//            } else {
//                B = (B > 1f) ? 1f : B;
//                //System.out.println("debug else : " + (B <= 0.1f));
//                if (B <= 0.1f ) {
//                    isUp = true;
//                } else {
//                    B -= 0.1f;
//                }
//            }
//        }

        R = (R >= 0.9f || R < 0f) ?  (isUp) ? 1f : 0f : (isUp) ? R+perubahan : R-perubahan ;
        if ((R > 0.9000001f && R <= 1f) || (R <= 0f && R > -1f)){
            if (isUp) {
                G = (G > 0.9000001f) ? 1f : G+perubahan;
                if (G >= 0.9f){
                    B = (B > 0.9000001f) ? 1f : B+perubahan;
                    if (B >=0.9f){
                        isUp = false;
                    }
                }

            }  else {

                if (R >= 0f){

                    G = (G <= 0f) ? 0f : G-perubahan;
                    if (G <= 0f){
                        B = (B <= 0f) ? 0f : B-perubahan;
                        if (B <=0f){
                            isUp = true;
                        }
                    }

                }

            }
        }
    }

}
