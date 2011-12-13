// ----------------------------------------------------------------------------
// CERTI - HLA RunTime Infrastructure
// Copyright (C) 2011 Eric Noulard
//
// This program is free software ; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public License
// as published by the Free Software Foundation ; either version 2 of
// the License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful, but
// WITHOUT ANY WARRANTY ; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this program ; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
//
// ----------------------------------------------------------------------------
package hla.rti1516e.jlc;

import hla.rti1516e.encoding.ByteWrapper;
import hla.rti1516e.encoding.DecoderException;
import hla.rti1516e.encoding.EncoderException;
import hla.rti1516e.encoding.HLAinteger64BE;

public class BasicHLAinteger64BE extends DataElementBase implements
        HLAinteger64BE {

    private long value;
    
    public BasicHLAinteger64BE() {
        value = 0L;
    }
    
    public BasicHLAinteger64BE(long value) {
        this.value = value;
    }
    
    @Override
    public int getOctetBoundary() {
        return 4;
    }

    @Override
    public void encode(ByteWrapper byteWrapper) throws EncoderException {
        byteWrapper.align(getOctetBoundary());
        byteWrapper.put((int)(value >>> 56) & 0xFF);
        byteWrapper.put((int)(value >>> 48) & 0xFF);
        byteWrapper.put((int)(value >>> 40) & 0xFF);
        byteWrapper.put((int)(value >>> 32) & 0xFF);
        byteWrapper.put((int)(value >>> 24) & 0xFF);
        byteWrapper.put((int)(value >>> 16) & 0xFF);
        byteWrapper.put((int)(value >>>  8) & 0xFF);
        byteWrapper.put((int)(value >>>  0) & 0xFF);
    }

    @Override
    public int getEncodedLength() {
        return 8;
    }

    @Override
    public void decode(ByteWrapper byteWrapper) throws DecoderException {
        byteWrapper.align(getOctetBoundary());
        value  = 0L;
        value += (long)((byteWrapper.get() & 0xFF) << 56);
        value += (long)((byteWrapper.get() & 0xFF) << 48);
        value += (long)((byteWrapper.get() & 0xFF) << 40);
        value += (long)((byteWrapper.get() & 0xFF) << 32);
        value += (long)((byteWrapper.get() & 0xFF) << 24);
        value += (long)((byteWrapper.get() & 0xFF) << 16);
        value += (long)((byteWrapper.get() & 0xFF) <<  8);
        value += (long)((byteWrapper.get() & 0xFF) <<  0);
    }

    @Override
    public void decode(byte[] bytes) throws DecoderException {
        value  = 0L;
        value += (long)((bytes[0] & 0xFF) << 56);
        value += (long)((bytes[1] & 0xFF) << 48);
        value += (long)((bytes[2] & 0xFF) << 40);
        value += (long)((bytes[3] & 0xFF) << 32);
        value += (long)((bytes[4] & 0xFF) << 24);
        value += (long)((bytes[5] & 0xFF) << 16);
        value += (long)((bytes[6] & 0xFF) <<  8);
        value += (long)((bytes[7] & 0xFF) <<  0);
    }

    @Override
    public long getValue() {
        return value;
    }

    @Override
    public void setValue(long value) {
        this.value = value;
    }

}