package cn.edu.scau.config;

import cn.edu.scau.entities.vo.Response;
import cn.edu.scau.exception.GlobalException;
import cn.edu.scau.exception.NotFoundException;
import cn.edu.scau.exception.RequestException;
import cn.edu.scau.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class RestExceptionHandler
{
    private static Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleRequestParaException(HttpMessageNotReadableException e){
        logger.error(e.getMessage(), e);
        return ResponseUtil.error(e.getMessage());

    }


    @ExceptionHandler(value = NotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response handleResourceNotFoundException(NotFoundException e)
    {
        logger.error(e.getMessage(), e);
        return ResponseUtil.error(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = RequestException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleBadRequestException(RequestException e)
    {
        logger.error(e.getMessage(), e);
        return ResponseUtil.error(e.getCode(),"参数问题",e.getMessage());
    }

    @ExceptionHandler(value = GlobalException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Response handleGlobalException(GlobalException e)
    {
        logger.error(e.getMessage(), e);
        return ResponseUtil.error(e.getCode(),"",e.getMessage());
    }
}
