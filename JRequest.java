/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 x86penguin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
*/

import java.net.*;
import java.io.*;
import java.util.*;

public class JRequest
{
    private String url;
    private String response;
    private String post;
    private StringBuilder responseBuilder = new StringBuilder();
    private StringBuilder postBuilder = new StringBuilder();

    public JRequest()
    {
        url = "http://www.google.com";
    }
    public JRequest(String url)
    {
        this.url = url;
    }

    public void setURL(String url)
    {
        this.url = url;
    }

    public String getResponse()
    {
        return response;
    }

    public void send()
    {
        try
        {
            URLConnection connection = new URL(url).openConnection();
            connection.connect();
            BufferedReader contents = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = contents.readLine()) != null)
            {
                responseBuilder.append(line + '\n');
            }
            contents.close();
            response = responseBuilder.toString();
        }
        catch (Exception e)
        {
            //This should be the final exeption block.
            //Include a useful output here and implement
            //more useful exception handling above.
            System.exit(1);
        }
    }
}
