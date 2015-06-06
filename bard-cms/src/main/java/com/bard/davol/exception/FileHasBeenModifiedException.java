package com.bard.davol.exception;

/**
 * Created by shuai.xiang@renren-inc.com on 14/12/27.
 */
public class FileHasBeenModifiedException extends  RuntimeException {

    public FileHasBeenModifiedException() {
        super("file may be motified");
    }
}
