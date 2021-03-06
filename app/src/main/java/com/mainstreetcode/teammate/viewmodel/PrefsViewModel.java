/*
 * MIT License
 *
 * Copyright (c) 2019 Adetunji Dahunsi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.mainstreetcode.teammate.viewmodel;

import com.mainstreetcode.teammate.model.Prefs;
import com.mainstreetcode.teammate.repository.PrefsRepo;
import com.mainstreetcode.teammate.repository.RepoProvider;

public class PrefsViewModel extends BaseViewModel {

    private Prefs prefs;
    private final PrefsRepo prefsRepository = RepoProvider.forRepo(PrefsRepo.class);

    public PrefsViewModel() {
        prefs = prefsRepository.getCurrent();
    }
    public boolean isOnBoarded() { return prefs.isOnBoarded(); }

    public void setOnBoarded(boolean isOnBoarded) {
        prefs.setOnBoarded(isOnBoarded);
        prefsRepository.createOrUpdate(prefs);
    }
}
