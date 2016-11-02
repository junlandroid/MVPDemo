package com.zhg.junl.utils.jsonparseutils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.google.gson.Gson;

public class JsonData<T> implements Serializable
{
    /**
	 * 顾俊华
	 * 2016-01-15
	 */
	private static final long serialVersionUID = 1L;
	
	private T      resultData;
    private String status;
    private String code;
    private String message;
    private String messagedetail;

    public T getResultData()
    {
        return resultData;
    }

    public void setResultData(T resultData)
    {
        this.resultData = resultData;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getMessagedetail()
    {
        return messagedetail;
    }

    public void setMessagedetail(String messagedetail)
    {
        this.messagedetail = messagedetail;
    }
    
  //将json字符串-->Common<clazz>
    public static JsonData fromJson(String json, Class clazz) {
		Gson gson = new Gson();
		Type objectType = type(JsonData.class, clazz);
		return gson.fromJson(json, objectType);
	}

    //将clazz-->json字符串
	public String toJson(Class<T> clazz) {
		Gson gson = new Gson();
		Type objectType = type(JsonData.class, clazz);
		return gson.toJson(this, objectType);
	}

	//类型转换
	static ParameterizedType type(final Class raw, final Type... args) {
		return new ParameterizedType() {
			public Type getRawType() {
				return raw;
			}

			public Type[] getActualTypeArguments() {
				return args;
			}

			public Type getOwnerType() {
				return null;
			}
		};
	}
    

}

