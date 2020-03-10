package cn.edu.scau.entities.vo;

public class Result
{
    /**
     * 错误内容
     */
    private String error;

    /**
     * 自定义错误码
     */
    private int code;


    public Result(String error, int code)
    {
        this.error = error;
        this.code = code;
    }

    public String getError()
    {
        return error;
    }

    public void setError(String error)
    {
        this.error = error;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }


    public enum ErrorCode{
        /**
         * 不存在
         */
        NOT_FOUND(40401),

        /**
         * 已存在
         */
        ALREADY_EXIST(40001),
        ;

        private int code;

        public int getCode()
        {
            return code;
        }

        ErrorCode(int code)
        {
            this.code = code;
        }
    }
}