/**
 * Copyright © 2018 Marcus Thiesen (marcus@thiesen.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.netty.handler.ssl;

import io.netty.util.ReferenceCounted;

import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLEngineResult.HandshakeStatus;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import java.nio.ByteBuffer;

public class ReferenceCountedOpenSslEngine extends SSLEngine implements ReferenceCounted, ApplicationProtocolAccessor {

	@Override
	public String getNegotiatedApplicationProtocol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int refCnt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReferenceCounted retain() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReferenceCounted retain(int increment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReferenceCounted touch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReferenceCounted touch(Object hint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean release() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean release(int decrement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void beginHandshake() throws SSLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInbound() throws SSLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeOutbound() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Runnable getDelegatedTask() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getEnableSessionCreation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] getEnabledCipherSuites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getEnabledProtocols() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HandshakeStatus getHandshakeStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getNeedClientAuth() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SSLSession getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getSupportedCipherSuites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getSupportedProtocols() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getUseClientMode() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getWantClientAuth() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInboundDone() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOutboundDone() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setEnableSessionCreation(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabledCipherSuites(String[] arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabledProtocols(String[] arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNeedClientAuth(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseClientMode(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWantClientAuth(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SSLEngineResult unwrap(ByteBuffer arg0, ByteBuffer[] arg1, int arg2, int arg3) throws SSLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SSLEngineResult wrap(ByteBuffer[] arg0, int arg1, int arg2, ByteBuffer arg3) throws SSLException {
		// TODO Auto-generated method stub
		return null;
	}

}
