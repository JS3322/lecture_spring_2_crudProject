package com.example.lecture_spring_2_crudproject.entity.data;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ConvolutionImage {

    public static void testImage(String input_readFile, String input_writeFile) throws IOException {
        String readFile = input_readFile;

        String writeFile = input_writeFile;
        File inputfile = new File(readFile);

        File outputFile = new File(writeFile);



        BufferedImage input = ImageIO.read(inputfile);

        // Create a black-and-white image of the same size.

        // BufferedImage.-> 여러가지의 이미지 효과가 저장
        BufferedImage im = new BufferedImage(input.getWidth(), input.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

        // Get the graphics context for the black-and-white image.

        // 여기서 이미지 효과를 저장 해서 만듬
        Graphics2D g2d = im.createGraphics();

        // Render the input image on it.
        g2d.drawImage(input, 0, 0, null);

        // Store the resulting image using the jpg format.
        ImageIO.write(im, "JPG", outputFile);
    }

    public static double[][] convolution(double[][] map, double[][] filter) {
        int c = 0;
        if (filter.length % 2 == 1) {
            int w = filter.length / 2;
            double[][] output = new double[map.length][map[0].length];
            for (int y = 0; y < map.length; y++) {
                for (int x = 0; x < map[y].length; x++) {
                    for (int i = 0; i < filter.length; i++) {
                        for (int j = 0; j < filter[i].length; j++) {
                            try {
                                output[y][x] += map[y - i + w][x - j + w] * filter[i][j];
                                c++;
                            } catch (ArrayIndexOutOfBoundsException e) {

                            }
                        }
                    }
                }
            }
            System.out.println(c + "번의 연산을 하였습니다.");
            return output;
        } else {
            //필터 크기가 짝수인 경우 무시
            return null;
        }
    }
}
