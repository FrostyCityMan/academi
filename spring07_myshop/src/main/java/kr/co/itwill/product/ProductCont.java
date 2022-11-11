package kr.co.itwill.product;

import java.io.File;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductCont {

    public ProductCont() {
        System.out.println("Product Cont created");
    }

    @Autowired
    ProductDAO productDAO;

    @RequestMapping("/")
    public String home() {
        //redirect list
        return "redirect:/product/list";
    }

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("product/list");
        //list add
        mv.setViewName("product/list");
        mv.addObject("list", productDAO.list());

        return mv;
    }// end of list

    @RequestMapping("/write")
    public String write() {
        return "product/write";
    }//end of write

    //insert mapping
    @RequestMapping("/insert")
    public String insert(@RequestParam Map<String, Object> map,
                         @RequestParam MultipartFile img,
                         HttpServletRequest request,
                         HttpServletResponse response) {
        String filename = "-";
        long filesize = 0;
        //if img is not null and img is empty then filename= img filename
        if (img != null && !img.isEmpty()) {
            filename = img.getOriginalFilename();
            filesize = img.getSize();
            try {
                ServletContext application = request.getSession().getServletContext();
                String path = application.getRealPath("/storage");
                img.transferTo(new File(path + "\\" + filename));
            } catch (Exception e) {
                e.printStackTrace();
            }//end of try-catch
        }//end of if
        map.put("filename", filename);
        map.put("filesize", filesize);
        productDAO.insert(map);
        return "redirect:/product/list";

    }//end of insert

    //modelandview search
    @RequestMapping("/search")
    public ModelAndView search(@RequestParam(defaultValue = "") String product_name) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("product/list");
        mv.addObject("list", productDAO.search(product_name));
        return mv;
    }

    //modelandview detail
    @RequestMapping("/detail/{product_code}")
    public ModelAndView detail(@PathVariable String product_code) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("product/detail");
        mv.addObject("product", productDAO.detail(product_code));
        return mv;
    }//end of detail

    //update
    @RequestMapping("/update")
    public String update(@RequestParam Map<String, Object> map,
                         @RequestParam MultipartFile img,
                         HttpServletRequest request,
                         HttpServletResponse response) {
        String filename = "-";
        long filesize = 0;
        //if img is not null and img is not empty then filename= img filename
        if (img != null && !img.isEmpty()) {
            filename = img.getOriginalFilename();
            filesize = img.getSize();
            try {
                ServletContext application = request.getSession().getServletContext();
                String path = application.getRealPath("/storage");
                img.transferTo(new File(path + "\\" + filename));
            } catch (Exception e) {
                e.printStackTrace();
            }//end of try-catch
        } else {
            //product_code
            String product_code = map.get("product_code").toString();
            Map<String, Object> product = productDAO.detail(product_code);
            filename = product.get("FILENAME").toString();
            //Integer.parseInt(String.valueOf(map.get("key")));
            //
            filesize = Integer.parseInt(String.valueOf(product.get("FILESIZE")));
        }//end of if
        map.put("filename", filename);
        map.put("filesize", filesize);
        productDAO.update(map);
        return "redirect:/product/list";
    }//end of update

    //delete
    @RequestMapping("/delete")
    public String delete(int product_code, HttpServletRequest request) {
        String filename = productDAO.filename(product_code);
        //if filename is not null and filename is not equals "-"
        if (filename != null && filename.equals("-")) {
            ServletContext application = request.getSession().getServletContext();
            String path = application.getRealPath("/storage");
            File file = new File(path + "\\" + filename);
            if (file.exists()) {
                file.delete();
            }//end of if
        }//end of if
        productDAO.delete(product_code);//행삭제
        return "redirect:/product/list";
    }//end of delete
} //end of ProductCont class
