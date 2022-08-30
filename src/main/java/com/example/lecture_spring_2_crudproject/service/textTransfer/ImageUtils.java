//package com.example.lecture_spring_2_crudproject.service.textTransfer;
//
//import org.apache.tomcat.util.http.fileupload.FileUtils;
//
//import java.io.File;
//import java.io.IOException;
//
//public class ImageUtils {
//    public static boolean convertFmt(File flSrc, File flTgt) throws Exception {
//        boolean result = false;
//        boolean isConvert = false;
//
//        String srcExt = FilenameUtils.getExtension(flSrc.getPath());
//
//        String tgtExt = FilenameUtils.getExtension(flTgt.getPath());
//
//        srcExt = srcExt.toLowerCase();
//        tgtExt = tgtExt.toLowerCase();
//
//        try{
//            //원본파일 복제
//            String strSrcPath = flSrc.getPath().split("\\.")[0];
//            String strOriPath = strSrcPath + "_ori." + srcExt;
//            File ori = new File(strOriPath);
//            FileUtils.copyFile(flSrc, ori);
//
//            FileInputStream inputStream = new FileInputStream(strOriPath);
//            FileOutputStream outputStream = new FileOutputStream(strSrcPath + "." + tgtExt);
//            BufferedImage oriImage = ImageIO.read(inputStream);
//
//            if(oriImage == null){
//                throw new BlcmException("허용되지 않은 형식의 파일입니다.");
//            }
//            BufferedImage newOriImage = new BufferedImage(oriImage.getWidth(),
//                    oriImage.getHeight(),
//                    BufferedImage.TYPE_INT_RGB);
//            newOriImage.createGraphics().drawImage(oriImage, 0, 0, Color.WHITE, null);
//
//            isConvert = ImageIO.write(newOriImage, tgtExt, outputStream);
//
//            outputStream.close();
//            inputStream.close();
//
//            if(isConvert){
//
//                if(ori.exists()){
//                    if(!FileUtils.deleteQuietly(ori)){
//                        ori.delete();
//                    }
//                }
//                if(flSrc.exists() && !flSrc.getPath().equals(flTgt.getPath())){
//                    if(!FileUtils.deleteQuietly(flSrc)){
//                        flSrc.delete();
//                    }
//                }
//
//            }
//
//            result = true;
//
//        } catch (IOException e) {
//            throw e;
//        } catch (IllegalArgumentException e) {
//            throw e;
//        }
//        return result;
//    }
//
//    public static void resizeImage(String srcPath, int maxWidth, int maxHeight) throws Exception{
//
//        //변환할 값과 비율
//        int rsltWidth = 0;
//        int rsltHeight = 0;
//        float maxRatio = maxHeight / (float)maxWidth;
//        String ext = FilenameUtils.getExtension(srcPath);
//
//        //이미지 읽기
//        File inputFile = new File(srcPath);
//        BufferedImage inputImage = ImageIO.read(inputFile);
//
//        //이미지 정보
//        int width = inputImage.getWidth();
//        int height = inputImage.getHeight();
//        float ratio = height / (float)width;
//
//        //사진이 변환 사이즈보다 클 경우 변환 진행
//        if(width > maxWidth || height > maxHeight) {
//
//            if(ratio < maxRatio) {
//                rsltWidth = (int)(width * (maxWidth / (float)width));
//                rsltHeight = (int)(height * (maxWidth / (float)width));
//            }else{
//                rsltWidth = (int)(width * (maxHeight / (float)height));
//                rsltHeight = (int)(height * (maxHeight / (float)height));
//            }
//
//        }else{
//            return;
//        }
//
//        Image srcImg = null;
//        if(ext.equals("bmp") || ext.equals("png") || ext.equals("gif")){
//            srcImg = ImageIO.read(inputFile);
//        }else{
//            srcImg = new ImageIcon(inputFile.toURL()).getImage();
//        }
//
//        Image imgTarget = srcImg.getScaledInstance(rsltWidth, rsltHeight, Image.SCALE_SMOOTH);
//        int pixels[] = new int[rsltWidth * rsltHeight];
//        PixelGrabber pg = new PixelGrabber(imgTarget, 0, 0, rsltWidth, rsltHeight, pixels, 0, rsltWidth);
//        pg.grabPixels();
//
//        BufferedImage outputImage = new BufferedImage(rsltWidth, rsltHeight, inputImage.getType());
//        outputImage.setRGB(0, 0,  rsltWidth, rsltHeight, pixels, 0, rsltWidth);
//
//        ImageIO.write(outputImage, ext, new File(srcPath));
//    }
//}
